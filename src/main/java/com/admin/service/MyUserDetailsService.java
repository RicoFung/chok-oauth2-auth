package com.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.admin.dao.TbUserDao;
import com.admin.domain.OauthAuthority;
import com.admin.domain.OauthUser;
import com.admin.entity.TbRole;
import com.admin.entity.TbUser;

import chok.devwork.springboot.BaseDao;
import chok.devwork.springboot.BaseService;

@Service
public class MyUserDetailsService extends BaseService<TbUser, Long> implements UserDetailsService
{
	@Autowired
	private TbUserDao dao;

	@Override
	public BaseDao<TbUser, Long> getEntityDao()
	{
		return dao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		OauthUser u = getByUsername(username);
		if (u == null)
		{
			throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
		}
		return new User(u.getUsername(), u.getPassword(), u.getAuthorities());
	}
	
	public OauthUser getByUsername(String username)
	{
		OauthUser oUser = null;
		TbUser tbUser = dao.getByUsername(username);
		if (null != tbUser)
		{
			oUser = new OauthUser();
			oUser.setUsername(tbUser.getTcName());
			oUser.setPassword(tbUser.getTcPassword());
			List<OauthAuthority> authorities = new ArrayList<OauthAuthority>();
			for(TbRole tbRole: tbUser.getTcRoles())
			{
				authorities.add(new OauthAuthority(tbUser.getTcCode(), tbRole.getTcCode()));
			}
			oUser.setAuthorities(authorities);
		}
		return oUser;
	}

//	public OauthUsers getByUsername(String username)
//	{
//		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
//		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/getByUsername?username=" + username;
//		System.out.println(url);
//		System.out.println(restTemplate.getForObject(url, TbUserDto.class));
//		
//		JSONObject json = restTemplate.getForObject(url, JSONObject.class);
//		TbUserDto userDto = json.getJSONObject("data").getJSONObject("po").toJavaObject(TbUserDto.class);
//		
//		OauthUsers oUser = new OauthUsers();
//		oUser.setUsername(userDto.getTcName());
//		oUser.setPassword(userDto.getTcPassword());
//		
//		List<OauthAuthorities> roles = new ArrayList<OauthAuthorities>();
//		for(TbRoleDto r: userDto.getTcRoles())
//		{
//			roles.add(new OauthAuthorities(userDto.getTcCode(), r.getTcCode()));
//		}
//		oUser.setAuthorities(roles);
//		return oUser;
//	}
}
