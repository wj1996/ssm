package com.wj.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wj.mybatis.pojo.User;
import com.wj.mybatis.utils.MybatisUtils;

public class MybatisTest4 {

	@Test
	public void test() throws Exception {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		User user = new User();
		user.setId(11113);
		user.setUsername("test");
		user.setAddress("家");
		sqlSession.update("user.updateUser",user);
		sqlSession.commit();
		sqlSession.close();
	}
}
