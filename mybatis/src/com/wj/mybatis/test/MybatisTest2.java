package com.wj.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wj.mybatis.pojo.User;
import com.wj.mybatis.utils.MybatisUtils;

public class MybatisTest2 {

	@Test
	public void test2() throws Exception {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		List<User> selectList = sqlSession.selectList("user.getUserByUserName", "张");
		for(User user : selectList) {
			System.out.println(user.getUsername());
		}
		sqlSession.close();
	}
}
