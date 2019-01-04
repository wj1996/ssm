package com.wj.mybatis.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.wj.mybatis.dao.impl.UserDaoImpl;
import com.wj.mybatis.dao.interfaces.UserDao;
import com.wj.mybatis.pojo.User;

public class UserDaoTest {

	@Test
	public void testGetUserById() {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserById(11113);
		System.out.println(user.getUsername());
	}

	@Test
	public void testGetUserByUserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertUser() {
		fail("Not yet implemented");
	}

}
