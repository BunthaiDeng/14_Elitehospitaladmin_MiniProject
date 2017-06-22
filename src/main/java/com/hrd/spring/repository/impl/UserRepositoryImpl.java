package com.hrd.spring.repository.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.hrd.spring.model.User;
import com.hrd.spring.repository.UserRepository;

@Repository("userRepositoryImpl")
public class UserRepositoryImpl implements UserRepository{

	@Override
	public ArrayList<User> findAllUser() {
		ArrayList<User> users = new ArrayList<>();
		users.add(new User("1", "Prohaska1", "M", "1-1-1990", "Admin"));
		users.add(new User("2", "Prohaska2", "M", "1-1-1990", "Member"));
		users.add(new User("3", "Prohaska3", "M", "1-1-1990", "Developer"));
		users.add(new User("4", "Prohaska4", "M", "1-1-1990", "Supporter"));
		users.add(new User("5", "Prohaska5", "M", "1-1-1990", "Member"));
		return users;
	}

}
