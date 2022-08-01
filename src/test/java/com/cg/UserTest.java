package com.cg;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.Repository.UserRepository;
import com.cg.dto.UserDto;
import com.cg.serviceimpl.UserService;

@SpringBootTest
public class UserTest {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void addUserTest() {
		UserDto userDto=new UserDto(1,"SoumyaReddy","12345","soumya","reddy",9876543210l,"sowmyareddy98g@gmail.com");
         assertNotNull(userService.addUser(userDto));	
	}
}
