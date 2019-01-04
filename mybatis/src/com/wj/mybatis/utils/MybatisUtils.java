package com.wj.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSession getSqlSession() throws Exception {
		// 创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		// 创建核心配置文件的输入流
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = ssfb.build(inputStream);
		// 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}

	static {
		try {
			// 创建SqlSessionFactoryBuilder对象
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			// 创建核心配置文件的输入流
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			sqlSessionFactory = ssfb.build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建SqlSessionFactory对象
		
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
