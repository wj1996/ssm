package com.wj.mybatis.dao.interfaces;

import java.util.List;

import com.wj.mybatis.pojo.User;

public interface UserDao {

	/**
	 * 根据用户编号获取用户
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
	
	/**
	 * 根据用户名称查找用户列表
	 * @param username
	 * @return
	 */
	List<User> getUserByUserName(String username);
	
	/**
	 * 增加用户
	 * @param user
	 */
	void insertUser(User user);
}
