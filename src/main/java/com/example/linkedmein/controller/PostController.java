package com.example.linkedmein.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.linkedmein.entity.Post;
import com.example.linkedmein.entity.User;
import com.example.linkedmein.service.CustomUserDetails;
import com.example.linkedmein.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	// get jobs page
	@GetMapping("/jobs")
	public String getJobsPage(Model model) {
		
		List<Post> posts = postService.retrieveAllPostProfile();
		model.addAttribute("posts", posts);
		
		return "jobs";
	}
	
	// get add-jobs page
	@GetMapping("/add_jobs")
	public String getAddJobsPage(Model model) {
		
		return "add_jobs";
	}
	
	@GetMapping("/edit_jobs")
	public String editJobsPage(Model model, @RequestParam("id") Integer id) {
		Post post = postService.getPostById(id);
		model.addAttribute("post", post);
		return "edit_jobs";
	}
	
	@GetMapping("/delete_jobs")
	public String DeleteUser(Model model, @ModelAttribute("post") Post post,
			@AuthenticationPrincipal CustomUserDetails loggedinUser) {


		
		postService.deleteJob(post);
		
		return "redirect:jobs";
		
	}
	
	
    // post method to process create jobs
    @PostMapping("/process_add_jobs")
    public String addJobs(Model model, @ModelAttribute("post") Post post) {
    	postService.savePost(post); // we dont have any checking if user exist for now, but later
    	return "redirect:jobs";
}
    
    @PostMapping("/jobs")
	public void search(Model model, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		List<Post> posts = postService.search(keyword);
		Integer count = posts.size();
		
		model.addAttribute("count", count);
		model.addAttribute("posts", posts);
		//return "dashboard";
	}
    
	@PostMapping("/update-jobs")
	public String UpdateJob(Model model, @ModelAttribute("post") Post post,
			@AuthenticationPrincipal CustomUserDetails loggedinUser) {
		
		postService.updatejobProfile(post);
		
		return "redirect:jobs";
		
	}
    
    

}
