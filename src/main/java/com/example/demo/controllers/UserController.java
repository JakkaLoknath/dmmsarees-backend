package com.example.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
@CrossOrigin(origins = {
		"http://localhost:5173",
		"https://dmmsarees-frontend.vercel.app"
})
public class UserController 
{
	private UserService userService;
	
	public UserController(UserService userService)
	{
		this.userService = userService;
	}
	
	@PostMapping("/newuser")
	public String newUser(@RequestBody User user)
	{
		return userService.userRegister(user);
	}
	
	@PostMapping("/getuser")
	public User getUser(@RequestBody User user)
	{
		return userService.userLogin(user.getMail(), user.getPassword());
	}
}
