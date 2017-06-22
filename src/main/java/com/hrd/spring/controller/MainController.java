package com.hrd.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrd.spring.model.User;
import com.hrd.spring.service.UserService;

import groovyjarjarantlr.collections.List;

@Controller
public class MainController {

	@Autowired
	@Qualifier("userServiceImpl")
	UserService userService;
	
//	@RequestMapping("/test")
//	@ResponseBody
//	public ArrayList<User> getTest(){
//		return userService.findAllUser();
//	}
	
	@RequestMapping("/mytest")
	@ResponseBody
	public ArrayList<User> getTest(){
		return userService.findAllUser();
	}	
	
	@RequestMapping({"/","/admin", "/dashboard"})
	public ModelAndView getDashBoard(ModelAndView model){
		model.addObject("pic", "d1.jpg");
		model.addObject("name", "Dr. Steve Gection");
		model.addObject("page","dashboard");
		model.setViewName("dashboard");
		
		return model;
	}
	
	
	@RequestMapping("/user-list")
	public ModelAndView getUserList(ModelAndView model){
		model.addObject("pic", "d1.jpg");
		model.addObject("name", "Dr. Steve Gection");		
		model.setViewName("user-list");
		model.addObject("page","userlist");
		if(users.isEmpty())
			model.addObject("data", userService.findAllUser());
		else
			model.addObject("data", users);
		return model;
	}
	
	@RequestMapping("/user-cu")
	public ModelAndView getUserCU(ModelAndView model){
		model.addObject("pic", "d1.jpg");
		model.addObject("name", "Dr. Steve Gection");		
		model.setViewName("user-cu");
		model.addObject("page","usercu");
		return model;
	}
	
	ArrayList<User> users = new ArrayList<>();
	@RequestMapping(value = "/user-cu", method=RequestMethod.POST)
	public void postUserCU(@ModelAttribute User user){
		user.setRole("Member");
		user.setSex("M");
		users.add(user);
	}
	
	
	
	@RequestMapping("/role-cu")
	public ModelAndView getRoleCU(ModelAndView model){
		model.addObject("pic", "d1.jpg");
		model.addObject("name", "Dr. Steve Gection");		
		model.setViewName("role-cu");
		model.addObject("page","rolecu");
		return model;
	}
	
	@RequestMapping("/role-list")
	public ModelAndView getRoleList(ModelAndView model){
		model.addObject("pic", "d1.jpg");
		model.addObject("name", "Dr. Steve Gection");		
		model.setViewName("role-list");
		model.addObject("page","rolelist");
		model.addObject("data", userService.findAllUser());
		return model;
	}	
	
	@RequestMapping("/user")
	public ModelAndView getUser(ModelAndView model){
		model.addObject("pic", "6.jpg");
		model.addObject("name", "Jane");
		model.setViewName("user");
		
		return model;
	}
	
}
