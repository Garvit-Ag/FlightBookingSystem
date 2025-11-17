package com.flightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.model.User;
import com.flightapp.service.UserService;

import jakarta.validation.Valid;

@RestController
public class AuthController {
	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	User saveUser(@RequestBody @Valid User user) {
		userService.insertUser(user);
		return user;
	}
	

}

