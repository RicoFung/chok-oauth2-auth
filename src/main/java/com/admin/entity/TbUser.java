package com.admin.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author rico
 * @version 1.0
 * @since 1.0
 */
public class TbUser implements Serializable
{
	private static final long serialVersionUID = 1L;

	// id db_column: id
	private java.lang.Long id;
	// tcCode db_column: tc_code
	private java.lang.String tcCode;
	// tcName db_column: tc_name
	private java.lang.String tcName;
	// tcEmail db_column: tc_email
	private java.lang.String tcEmail;
	// tcPassword db_column: tc_password
	private java.lang.String tcPassword;
	// tcAddTime db_column: tc_add_time
	private java.lang.String tcAddTime;
	// tcEnable db_column: tc_enable
	private java.lang.Boolean tcEnable;

	private List<TbRole> tcRoles;

	public TbUser()
	{
	}

	public TbUser(java.lang.Long id, java.lang.String tcCode, java.lang.String tcName, java.lang.String tcEmail,
			java.lang.String tcPassword, java.lang.String tcAddTime, java.lang.Boolean tcEnable)
	{
		this.id = id;
		this.tcCode = tcCode;
		this.tcName = tcName;
		this.tcEmail = tcEmail;
		this.tcPassword = tcPassword;
		this.tcAddTime = tcAddTime;
		this.tcEnable = tcEnable;
	}

	public void setId(java.lang.Long value)
	{
		this.id = value;
	}

	public java.lang.Long getId()
	{
		return this.id;
	}

	public void setTcCode(java.lang.String value)
	{
		this.tcCode = value;
	}

	public java.lang.String getTcCode()
	{
		return this.tcCode;
	}

	public void setTcName(java.lang.String value)
	{
		this.tcName = value;
	}

	public java.lang.String getTcName()
	{
		return this.tcName;
	}

	public void setTcEmail(java.lang.String value)
	{
		this.tcEmail = value;
	}

	public java.lang.String getTcEmail()
	{
		return this.tcEmail;
	}

	public void setTcPassword(java.lang.String value)
	{
		this.tcPassword = value;
	}

	public java.lang.String getTcPassword()
	{
		return this.tcPassword;
	}

	public void setTcAddTime(java.lang.String value)
	{
		this.tcAddTime = value;
	}

	public java.lang.String getTcAddTime()
	{
		return this.tcAddTime;
	}

	public void setTcEnable(java.lang.Boolean value)
	{
		this.tcEnable = value;
	}

	public java.lang.Boolean getTcEnable()
	{
		return this.tcEnable;
	}

	public void setTcRoles(List<TbRole> tcRoles)
	{
		this.tcRoles = tcRoles;
	}

	public List<TbRole> getTcRoles()
	{
		return tcRoles;
	}
}
