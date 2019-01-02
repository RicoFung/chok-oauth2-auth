package com.admin.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.admin.entity.TbUser;

import chok.devwork.springboot.BaseDao;

@Repository
public class TbUserDao extends BaseDao<TbUser,Long>
{
	@Resource//(name = "firstSqlSessionTemplate")
	private SqlSession sqlSession;

	@Override
	protected SqlSession getSqlSession()
	{
		return sqlSession;
	}
	
	@Override
	public Class<TbUser> getEntityClass()
	{
		return TbUser.class;
	}
	
	public TbUser getByUsername(String username)
	{
		return (TbUser) get("getByUsername", username);
	}
}
