package com.webconfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		// @formatter:off
		http
		// Since we want the protected resources to be accessible in the UI as well we
		// need
		// session creation to be allowed (it's disabled by default in 2.0.6)
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and().requestMatchers()
		.anyRequest().and().anonymous().and().authorizeRequests()
		// .antMatchers("/order/**").access("#oauth2.hasScope('select') and
		// hasRole('ROLE_USER')")
		.antMatchers("/product/**").authenticated();// 配置order访问控制，必须认证过后才可以访问
		// @formatter:on
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception
	{
		resources.authenticationEntryPoint(new MyAuthenticationEntryPoint());
	}

	/**
	 * 自定义Token异常信息 用于token校验失败返回信息401
	 * 
	 * @author zhuojun.feng
	 *
	 */
	private class MyAuthenticationEntryPoint implements AuthenticationEntryPoint
	{
		@Override
		public void commence(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException authException) throws IOException, ServletException
		{
			log.error(authException.getMessage());
			request.setAttribute("msg", authException.getMessage());
			request.getRequestDispatcher("error/401").forward(request, response);
		}
	}
}
