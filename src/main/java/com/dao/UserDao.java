package com.dao;

public interface UserDao {

	boolean isValidUser(String username, String password);

	boolean addUser(User1 user);

}
