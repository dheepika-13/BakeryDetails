package com.bakery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bakery.model.User;
import com.bakery.service.UserService;


@RestController
public class UserController {
	@Autowired
	UserService usrService;
		@PostMapping("/checkLogin")
		public String validateUser(@RequestBody User u)
		{
			System.out.println(u.getUsername());
			return usrService.validateUser(u.getUsername(),u.getPassword());
		}
		@PostMapping("/addUser")
			public User saveInfo(@RequestBody User ui)
			{
				return usrService.saveUser(ui);
			}

}



