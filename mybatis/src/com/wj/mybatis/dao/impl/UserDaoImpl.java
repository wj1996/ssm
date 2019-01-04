package com.wj.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wj.mybatis.dao.interfaces.UserDao;
import com.wj.mybatis.pojo.User;
import com.wj.mybatis.utils.MybatisUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserById(Integer id) {
		SqlSession openSession = MybatisUtils.getSqlSessionFactory().openSession();
		User user = openSession.selectOne("user.getUserById", id);
		return user;
	}

	@Override
	public List<User> getUserByUserName(String username) {
		SqlSession openSession = MybatisUtils.getSqlSessionFactory().openSession();
		return openSession.selectList("user.getUserByUserName", username);
	}

	@Override
	public void insertUser(User user) {
		SqlSession openSession = MybatisUtils.getSqlSessionFactory().openSession();
		openSession.insert("user.insertUser");
	}

}
