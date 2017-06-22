package com.hrd.spring.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hrd.spring.model.User;
import com.hrd.spring.repository.UserRepository;
import com.hrd.spring.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Qualifier("userRepositoryImpl")
	UserRepository userRepository;
	
	
	@Override
	public ArrayList<User> findAllUser() {
		return userRepository.findAllUser();
	}

}
