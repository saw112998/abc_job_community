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

import com.example.linkedmein.entity.Post;
import com.example.linkedmein.repository.PostRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class PostRepositoryTest { 
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateNewPost() {
		Post post = new Post();
		post.setCompany("Network of Haven");
		post.setPosition("Networking");
		post.setSalary("2500");
		
		Post savedPost = entityManager.persistAndFlush(post); // retrive object using em
		
		assertThat(savedPost.getCompany()).isEqualTo(post.getCompany());
	}
	
	@Test
	public void testNumberPostingJobs() {
		long count = postRepo.count();
		System.err.println("size: " + count);
		assertThat(count).isEqualTo(postRepo.findAll().size());
	}
	
	@Test
	public void testSearchByKeyword() {
		String keyword = "flower";
		List<Post> results = postRepo.search(keyword);
		
		assertThat(results.size()).isEqualTo(postRepo.search(keyword).size());
	}
	
	@Test
	public void testFindPostByCompany() {
		String company = "flower";
		Post post = postRepo.findPostByCompany(company);
		
		assertThat(post.getCompany()).isEqualTo(company);
	}
	
	@Test
	public void testFindPostByCity() {
		String city = "penang";
		Post post = postRepo.findPostByCity(city);
		
		assertThat(post.getCity()).isEqualTo(city);
	}
	
	@Test
	public void testDeletePostById() {
		Post post = postRepo.findPostByCompany("Network of Haven");		
		postRepo.deleteById(post.getId()); 
		 
		Post deletedPost = postRepo.findPostByCompany("Network of Haven");
		
		assertThat(deletedPost).isEqualTo(null);
	}
}
