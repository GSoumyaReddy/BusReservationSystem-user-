package com.cg.service;

import java.util.List;

import com.cg.dto.UserDto;
import com.cg.entity.User;

public interface IUserService {
	
	public User addUser(UserDto userdto);
	public UserDto updateUser(int userId,UserDto userDto);
	public User deleteUser(int userLoginId);
	public UserDto viewUser(int userId);
	public List<UserDto> viewAllUsers();

}
