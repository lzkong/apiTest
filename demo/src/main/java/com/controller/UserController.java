package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping(value = "/try")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user")
	public List<User> getUsers() {
		return userService.selectUsers();
	}

}
