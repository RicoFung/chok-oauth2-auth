package com.admin.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author rico
 * @version 1.0
 * @since 1.0
 */
public class OauthAuthority implements GrantedAuthority
{
	private static final long serialVersionUID = 1L;
	// username db_column: username
	private java.lang.String username;
	// authority db_column: authority
	private java.lang.String authority;

	public OauthAuthority()
	{
	}

	public OauthAuthority(java.lang.String username, java.lang.String authority)
	{
		this.username = username;
		this.authority = authority;
	}

	public void setUsername(java.lang.String value)
	{
		this.username = value;
	}

	public java.lang.String getUsername()
	{
		return this.username;
	}

	public void setAuthority(java.lang.String value)
	{
		this.authority = value;
	}

	public java.lang.String getAuthority()
	{
		return this.authority;
	}
}
