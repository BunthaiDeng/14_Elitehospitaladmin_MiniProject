package com.hrd.spring.repository;

import java.util.ArrayList;

import com.hrd.spring.model.User;

public interface UserRepository {
	public ArrayList<User> findAllUser();
}
