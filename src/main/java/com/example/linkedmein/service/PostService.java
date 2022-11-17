package com.example.linkedmein.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.linkedmein.entity.Post;
import com.example.linkedmein.entity.User;
import com.example.linkedmein.repository.PostRepository;
import com.example.linkedmein.repository.UserRepository;

@Service
@Transactional
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	//default constructor
	public PostService(PostRepository postRepo) {
		this.postRepository = postRepo;
	}
	
	// save, update user object
	public void savePost(Post post) {
		postRepository.save(post);
	}
	
    // return all user's information, but hey, we may want to retrieve all except password right?! think about it!
    public List<Post> retrieveAllPostProfile() {
	return postRepository.findAll();
}
    
    public List<Post> search(String keyword) {
		return postRepository.search(keyword);
	}
    
	public Post getPostById(Integer id) {
		return postRepository.findById(id).get();
	}
	
	public Post getPostByCompany(String company) {
		return postRepository.findPostByCompany(company);
	}
	
	//update user object 
	public void updatejobProfile(Post tmp) {
		Post post = postRepository.findById(tmp.getId()).get();
		
		post.setCompany(tmp.getCompany());
		post.setPosition(tmp.getPosition());
		post.setCity(tmp.getCity());
		post.setCountry(tmp.getCountry());
		post.setSalary(tmp.getSalary());
		post.setContent(tmp.getContent());
		
		postRepository.save(post);
		
	}
	
	public void deleteJob(Post tmp) {
		Post post = postRepository.findById(tmp.getId()).get();

		
		postRepository.delete(post);
		
	}

}
