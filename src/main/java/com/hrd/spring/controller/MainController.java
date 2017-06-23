package com.hrd.spring.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrd.spring.model.User;
import com.hrd.spring.service.UserService;


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
		
		int total = 0, totalM = 0, totalF = 0;
		for(User u : userService.findAllUser()){
			
			if("M".equals(u.getGender()))
				totalM++;
			else
				totalF++;
			
			total++;
		}
		
		model.addObject("total", total);
		model.addObject("totalM", totalM);
		model.addObject("totalF", totalF);
		
		return model;
	}
	
	
	@RequestMapping("/user-list")
	public ModelAndView getUserList(ModelAndView model){
		model.addObject("pic", "d1.jpg");
		model.addObject("name", "Dr. Steve Gection");		
		model.setViewName("user-list");
		model.addObject("page","userlist");

		model.addObject("data", userService.findAllUser());

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
	
	@RequestMapping(value = "/user-cu", method=RequestMethod.POST)
	public void postUserCU(@ModelAttribute User user){
		user.setUserhash(UUID.randomUUID().toString());
		userService.addUser(user);
	}
	
	@RequestMapping("/user-update/{username}/{email}/{gender}/{phonenumber}/{userhash}")
	public ModelAndView getUserUpdate(ModelAndView model,
										@PathVariable("username") String username,
										@PathVariable("email") String email,
										@PathVariable("gender") String gender,
										@PathVariable("phonenumber") String phonenumber,
										@PathVariable("userhash") String userhash){
		model.addObject("pic", "d1.jpg");
		model.addObject("name", "Dr. Steve Gection");		
		model.setViewName("user-update");
		model.addObject("page","userupdate");
		model.addObject("username", username);
		model.addObject("email", email);
		model.addObject("gender", gender);
		model.addObject("phonenumber", phonenumber);
		model.addObject("userhash", userhash);
		return model;
	}
	
	@RequestMapping("/user-profile/{username}/{email}/{gender}/{phonenumber}/{userhash}")
	public ModelAndView getUserProfile(ModelAndView model,
										@PathVariable("username") String username,
										@PathVariable("email") String email,
										@PathVariable("gender") String gender,
										@PathVariable("phonenumber") String phonenumber,
										@PathVariable("userhash") String userhash){
		model.addObject("pic", "d1.jpg");
		model.addObject("name", "Dr. Steve Gection");		
		model.setViewName("user-profile");
		model.addObject("page","userupdate");
		model.addObject("username", username);
		model.addObject("email", email);
		model.addObject("gender", gender);
		model.addObject("phonenumber", phonenumber);
		model.addObject("userhash", userhash);
		return model;
	}		
	
	@RequestMapping(value = "/user-update", method=RequestMethod.POST)
	public void postUserUpdate(@ModelAttribute User user){
//		System.out.println(user);
		userService.updateUser(user);
	}
	
	@RequestMapping(value = "/{userhash}")
	public ModelAndView deleteUser(@PathVariable("userhash") String userhash, ModelAndView model){
		userService.deleteUser(userhash);
		
		model.addObject("pic", "d1.jpg");
		model.addObject("name", "Dr. Steve Gection");		
		model.setViewName("user-list");
		model.addObject("page","userlist");

		model.addObject("data", userService.findAllUser());

		return model;
	}
	
//	@RequestMapping(value = "/user-cu", method=RequestMethod.POST)
//	@ResponseBody
//	public User postUserCU(@ModelAttribute User user){
////		userService.addUser(user);
//		return user;
//	}	
	
	
	
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
