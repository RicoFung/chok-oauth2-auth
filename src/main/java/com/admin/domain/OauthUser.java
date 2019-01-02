package com.admin.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author rico
 * @version 1.0
 * @since 1.0
 */
public class OauthUser implements UserDetails
{
	private static final long serialVersionUID = 1L;

	// username db_column: username
	private String username;
	// password db_column: password
	private String password;
	// enabled db_column: enabled
	private Boolean enabled;

    private List<OauthAuthority> authorities;

	public OauthUser()
	{
	}

	public OauthUser(String username, String password, Boolean enabled)
	{
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public void setUsername(String value)
	{
		this.username = value;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setPassword(String value)
	{
		this.password = value;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setEnabled(Boolean value)
	{
		this.enabled = value;
	}
	
	public void setAuthorities(List<OauthAuthority> authorities)
	{
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return this.authorities;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return false;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return false;
	}

	@Override
	public boolean isEnabled()
	{
		return this.enabled;
	}
}
