package com.example.linkedmein;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.linkedmein.entity.User;
import com.example.linkedmein.repository.UserRepository;

import net.bytebuddy.utility.RandomString;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class UserRepositoryTest {
	
	@Autowired  
	private UserRepository userRepo;
	
	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testCreateNewUser() {
		User user = new User();
		user.setUsername("test-admin");
		user.setEmail("admin@example.com");
		user.setPassword("password");
		
		User savedUser = entityManager.persistAndFlush(user); 
		
		assertThat(savedUser.getEmail()).isEqualTo(user.getEmail());
	}
	
	@Test
	public void testCountRegisteredUsers() {
		long count = userRepo.count();
		System.err.println("size: " + count);
		assertThat(count).isEqualTo(userRepo.findAll().size());
	}
	
	@Test
	public void testSearchByKeyword() {
		String keyword = "penang";
		List<User> results = userRepo.search(keyword);
		
		assertThat(results.size()).isEqualTo(userRepo.search(keyword).size());
	}
	
	@Test
	public void testFindUserByEmail() {
		String email = "yexuan10024@gmail.com";
		User user = userRepo.findUserByEmail(email);
		
		assertThat(user.getEmail()).isEqualTo(email);
	}
	 
	@Test
	public void testFindUserByUsername() {
		String username = "admin";
		User user = userRepo.findUserByUsername(username);
		
		assertThat(user.getUsername()).isEqualTo(username);
	}
	
	@Test
	public void testFindUserByVerificationCode() {
		String verficationCode = RandomString.make(64);
		
		User user = userRepo.findUserByUsername("admin");
		user.setVerificationCode(verficationCode);
		
		User existedUser = userRepo.findByVerificationCode(verficationCode);
		
		assertThat(existedUser.getVerificationCode()).isEqualTo(verficationCode);
	}
	
	@Test
	public void testFindUserByResetPasswordToken() {
		String resetPasswordToken = RandomString.make(30);
		
		User user = userRepo.findUserByUsername("admin");
		user.setResetPasswordToken(resetPasswordToken);
		
		User existedUser = userRepo.save(user);
		User savedUser = userRepo.findByResetPasswordToken(resetPasswordToken);
		
		assertThat(existedUser.getResetPasswordToken()).isEqualTo(savedUser.getResetPasswordToken());
	}
	
	@Test
	public void testDeleteUserById() {
		User user = userRepo.findUserByUsername("test-admin");		
		userRepo.deleteById(user.getId()); // delete the user by id
		
		User deletedUser = userRepo.findUserByUsername("test-admin"); // test retrieve it back
		
		assertThat(deletedUser).isEqualTo(null);
	}


}
