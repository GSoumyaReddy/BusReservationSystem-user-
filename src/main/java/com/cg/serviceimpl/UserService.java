package com.cg.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Repository.UserRepository;
import com.cg.dto.UserDto;
import com.cg.entity.User;
import com.cg.exceptions.UserNotFoundException;
import com.cg.service.IUserService;

@Service

public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(UserDto userdto)
	{
		User user=new User();
		BeanUtils.copyProperties(userdto, user);
		userRepository.save(user);
		return user;
	}
	
	public UserDto updateUser(int userId,UserDto userDto) {
		
		if(!userRepository.existsById(userId)) {
			throw new UserNotFoundException();
		}
		
		UserDto userDto1=new UserDto();
        User user=new User();
        BeanUtils.copyProperties(userRepository.findById(userId).get(),userDto);
        //userDto1.setUserLoginId(userDto.getUserLoginId());
        userDto1.setUserName(userDto.getUserName());
        userDto1.setPassword(userDto.getFirstName());
        userDto1.setFirstName(userDto.getFirstName());
        userDto1.setLastName(userDto.getLastName());
        userDto1.setContact(userDto.getContact());
        userDto1.setEmail(userDto.getEmail());
        BeanUtils.copyProperties(userDto,userDto);
        userRepository.save(user);
        userRepository.flush();
        return userDto;
	}
	
	public User deleteUser(int userLoginId) {
		
		if(!userRepository.existsById(userLoginId)) {
			throw new UserNotFoundException();
		}
		
		UserDto userDto=new UserDto();
		User user=new User();
		BeanUtils.copyProperties(userRepository.findById(userLoginId).get(), user);
		BeanUtils.copyProperties(userDto,user);
		userRepository.deleteById(userLoginId);
		return user;
	}
	
	
	public UserDto viewUser(int userId) {
		
		if(!userRepository.existsById(userId)) {
			throw new UserNotFoundException();
		}
		
		
		UserDto userDto=new UserDto();
		User user=new User();
		BeanUtils.copyProperties(userRepository.findById(userId).get(),user);
		BeanUtils.copyProperties(user,userDto);
		return userDto;
		}
	

	public List<UserDto> viewAllUsers() {
		List<UserDto>userDtoList=new ArrayList<>();
		List<User>userList=userRepository.findAll();
		for(User user:userList) {
			UserDto userDto=new UserDto();
			BeanUtils.copyProperties(user, userDto);
			userDtoList.add(userDto);
		}
		return userDtoList;
	}
		
	
	
	

}
