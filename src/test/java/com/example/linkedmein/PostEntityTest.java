package com.example.linkedmein;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.linkedmein.entity.Post;
import com.example.linkedmein.repository.PostRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class PostEntityTest {
	
	@Autowired
	private PostRepository postRepo;
	
	@Test
	public void testFindPostById() {
		Integer id = 2;
		Post post = postRepo.findPostById(id);
		
		assertThat(post.getId()).isEqualTo(id);
	}
	
	@Test 
	public void testFindPostByCompany() {
		String company = "flower";
		Post post = postRepo.findPostByCompany(company);
		
		assertThat(post.getCompany()).isEqualTo(company);
	} 
	
	@Test
	public void testFindPostByPosition() {
		String position = "engineer";
		Post post = postRepo.findPostByPosition(position);
		
		assertThat(post.getPosition()).isEqualTo(position);
	}

}
