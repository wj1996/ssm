package com.wj.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wj.mybatis.pojo.User;

public class MybatisTest {

	@Test
	public void test() throws IOException {
		//创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//创建核心配置文件的输入流
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = ssfb.build(inputStream);
		//创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行查询
		User user = sqlSession.selectOne("user.getUserById", 1);
		//释放资源
		sqlSession.close();
		System.out.println(user.getUsername());
	}
}
