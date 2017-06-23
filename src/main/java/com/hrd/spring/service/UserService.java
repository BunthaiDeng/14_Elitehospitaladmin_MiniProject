package com.hrd.spring.service;

import java.util.ArrayList;

import com.hrd.spring.model.User;

public interface UserService {
	public ArrayList<User> findAllUser();
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(String userhash);
}
