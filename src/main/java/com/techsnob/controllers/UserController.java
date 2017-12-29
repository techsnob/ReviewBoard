package com.techsnob.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techsnob.entities.User;
import com.techsnob.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/")
	public String showHomePage(){
		return "index";
	}
	
	@RequestMapping(value="/register")
	public String register(@ModelAttribute User user){
		userService.saveUser(user);
		return "Successfully added "+user.getUsername();
	}
}
