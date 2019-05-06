package com.niit.autoback.dao;

import com.niit.autoback.model.User;

public interface UserDao {
	
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User getUser(String username);

}
