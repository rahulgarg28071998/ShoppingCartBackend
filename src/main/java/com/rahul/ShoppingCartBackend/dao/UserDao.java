package com.rahul.ShoppingCartBackend.dao;

import com.rahul.ShoppingCartBackend.dto.User;

public interface UserDao {


	public User getUserByUsername(String email);
	boolean add(User user);
	boolean update(User user);
	boolean delete(String email);
	public User getUserById(int user_id);
}
