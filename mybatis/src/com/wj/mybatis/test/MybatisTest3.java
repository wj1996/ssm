package com.wj.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wj.mybatis.pojo.User;
import com.wj.mybatis.utils.MybatisUtils;

public class MybatisTest3 {

	@Test
	public void test() throws Exception {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		User user = new User();
		user.setUsername("wrf");
		sqlSession.insert("user.insertUser",user);
		System.out.println(user.getId());
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void test2() throws Exception {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		User user = new User();
		user.setUsername("wrf");
		sqlSession.insert("user.insertUserUUID",user);
		System.out.println(user.getId() + user.getUuid2());
		sqlSession.commit();
		sqlSession.close();
	}
}
