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

import com.example.linkedmein.entity.Post;
import com.example.linkedmein.repository.PostRepository;
import com.example.linkedmein.service.PostService;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class PostServiceTest {
	 
	@Mock
	private PostRepository postRepo;


	private PostService postService;
	
	@BeforeEach void setup() {
		postService= new PostService(postRepo);
	}
	
	@Test
	public void getAllPostTest() {
		List<Post> savedPosts = postService.retrieveAllPostProfile(); 
		verify(postRepo).findAll(); 
	}
	
	@Test
	public void getSearchPostsTest() {
		
		Post post = new Post();	
		
				
		List<Post> SearchPost = postService.search(post.getCompany()); 
		verify(postRepo).search(post.getCompany()); 
	}
	
	@Test
	public void getPostByCompany() {
		
		Post post = new Post();		
		
		Post Post = postService.getPostByCompany(post.getCompany());
	    verify(postRepo).findPostByCompany(post.getCompany());
	}
	

}
