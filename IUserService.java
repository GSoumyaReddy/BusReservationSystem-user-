package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Repository.IUserRepository;
import com.cg.dto.UserDto;
import com.cg.entity.User;

@Service

public class IUserService {
	
	private static final Object UserDto = null;
	@Autowired
	private IUserRepository iUserRepository;
	
	
	
	public User addUser(UserDto userdto)
	{
		User user=new User();
		BeanUtils.copyProperties(userdto, user);
		iUserRepository.save(user);
		return user;
	}
	
	public UserDto updateUser(int userId,String name) {
		User user=new User();
		UserDto userDto=new UserDto();
		iUserRepository.findById(userId).get();
		BeanUtils.copyProperties(UserDto,user);
		iUserRepository.flush();
		iUserRepository.save(user);
		return userDto;
		
	}
	
	
		
		
	
	
	public User deleteUser(int userLoginId) {
		User user=iUserRepository.findById(userLoginId).get();
		BeanUtils.copyProperties(userLoginId,user);
		iUserRepository.deleteById(userLoginId);
		return user;
	}
	public User viewUser(int userId) {
		
		User user=iUserRepository.findById(userId).get();
		BeanUtils.copyProperties(userId, user);
		iUserRepository.save(user);
		return user;
	}

	public List<UserDto> viewAllUsers() {
		
		List<UserDto>userDtoList=new ArrayList<>();
		List<User>userList=iUserRepository.findAll();
		UserDto userDto=new UserDto();
		for(User user:userList) {
			BeanUtils.copyProperties(user, userDto);
			userDtoList.add(userDto);
		}
		return userDtoList;
	}
		
	
	
	

}
