package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	public IUserService userService;
	
	@RequestMapping("/user")
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping("/{userId}/{username}")
	public User updateUser(@PathVariable("userId")int userId,@PathVariable("name")String name) {
     return userService.updateUser(userId,name);
	}
	
	@DeleteMapping("/{userLoginId}")
	public User deleteUser(@PathVariable("userLoginId")int userLoginId) {
		return userService.deleteUser(userLoginId);
	}
	
	@GetMapping("/{userid}")
	public User viewUser(@PathVariable("id")int userLoginId) {
		return userService.viewUser(userLoginId);
	}
	
	@GetMapping
	public List<User>viewAllUsers(){
		return userService.viewAllUsers();
	}
	
	
     

}
