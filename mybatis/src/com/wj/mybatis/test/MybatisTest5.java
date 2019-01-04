package com.wj.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wj.mybatis.utils.MybatisUtils;

public class MybatisTest5 {

	@Test
	public void test() throws Exception {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		sqlSession.update("user.deleteUser", 11118);
		sqlSession.commit();
		sqlSession.close();
	}
}
