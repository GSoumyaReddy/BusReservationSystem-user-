package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.UserDto;
import com.cg.entity.User;
import com.cg.exceptions.UserNotFoundException;
import com.cg.serviceimpl.UserService;

@SuppressWarnings("unused")
@RestController

@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	
	@PostMapping
	public User addUser(@RequestBody UserDto userdto) {
		return userService.addUser(userdto);
	}
	
	@PatchMapping("/{userId}")
	public UserDto updateUser(@PathVariable("userId")
	int userId,@RequestBody UserDto userDto) {
     return userService.updateUser(userId,userDto);
	}
	
	@DeleteMapping("/{userLoginId}")
	public User deleteUser(@PathVariable("userLoginId")int userLoginId) {
		return userService.deleteUser(userLoginId);
	}
	
	@GetMapping("/{userid}")
	public UserDto viewUser(@PathVariable("userid")int userLoginId) {
		return userService.viewUser(userLoginId );
	}
	
	@GetMapping("/viewAll")
	public List<UserDto> viewAllUsers(){
		return  userService.viewAllUsers();
	}
	
	
     

}
