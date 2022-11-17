package com.example.linkedmein;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.linkedmein.entity.User;
import com.example.linkedmein.repository.UserRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class UserEntityTest {
	 
	
	@Autowired
	private UserRepository userRepo;

	@Test
	public void testFindUserById() {
		Integer id = 87;
		User user = userRepo.findUserByID(id);
		
		assertThat(user.getId()).isEqualTo(id);
	}
	
	@Test
	public void testFindUserByEmail() {
		String email = "yexuan10024@gmail.com";
		User user = userRepo.findUserByEmail(email);
		
		assertThat(user.getEmail()).isEqualTo(email);
	}
	
	@Test
	public void testFindUserByUser() {
		String username = "admin";
		User user = userRepo.findUserByUsername(username);
		
		assertThat(user.getUsername()).isEqualTo(username);
	}
}
