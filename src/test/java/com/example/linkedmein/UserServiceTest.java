package com.example.linkedmein;


import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.linkedmein.entity.User;
import com.example.linkedmein.repository.UserRepository;
import com.example.linkedmein.service.UserService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class UserServiceTest { 
	
	@Mock
	private UserRepository userRepo;

 
	private UserService userService;
	
	@BeforeEach void setup() {
		userService= new UserService(userRepo);
	}

	@Test
	public void getAllUserTest() {
		List<User> savedUsers = userService.retrieveAllUserProfile(); 
		verify(userRepo).findAll(); 
	}
	
	@Test
	public void getSearchUserTest() {
		
		User user = new User();	
		
				
		List<User> SearchUser = userService.search(user.getUsername()); 
		verify(userRepo).search(user.getUsername()); 
	}
	
	@Test
	public void getUserByUsername() {
		
		User user = new User();		
		
	    User User = userService.getUserByUsername(user.getUsername());
	    verify(userRepo).findUserByUsername(user.getUsername());
	}
	
	
	
	

}
