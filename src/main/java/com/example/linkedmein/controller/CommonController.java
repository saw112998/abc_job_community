package com.example.linkedmein.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.linkedmein.entity.User;
import com.example.linkedmein.service.CustomUserDetails;
import com.example.linkedmein.service.UserService;

import net.bytebuddy.utility.RandomString;

@Controller
public class CommonController {
	
	@Autowired
	private JavaMailSender mailSender;	
	
	@Autowired
	private UserService userService;
	
	// get homepage
	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}
	
	// get homepage
	@GetMapping("/getHomePage")
	public String getHomePage1() {
		return "index";
	}
	
	// get sign up
	@GetMapping("/getSignUp")
	public String getSignUp() {
		return "signup";
	}
	
	// get sign in
	@GetMapping("/signin")
	public String getSignIp() {
		return "signin";
	}
	
	// get sign in
	@GetMapping("/reset_success")
	public String getReset() {
		return "reset_success";
	}
	
	
	
	// get dashboard
	@GetMapping("/getDashboardPage")
	public String getDashboardPage(Model model, @CurrentSecurityContext(expression = "authentication?.name") String username) {
		List<User> users = userService.retrieveAllUserProfile();
		model.addAttribute("users", users);
		
		//retrieve loggedinuser id
		User loggedInUser = userService.getUserByUsername(username);
		model.addAttribute("loggedinuser", loggedInUser);
		
		return "dashboard";
	}
	
	
	
	// get dashboard
	@GetMapping("/dashboard")
	public String getSearchDashboardPage(Model model, @CurrentSecurityContext(expression = "authentication?.name") String username) {
		List<User> users = userService.retrieveAllUserProfile();
		model.addAttribute("users", users);
		
		//retrieve loggedinuser id
		User loggedInUser = userService.getUserByUsername(username);
		model.addAttribute("loggedinuser", loggedInUser);
		
		return "dashboard";
	}
	

	
	//get profile
	@GetMapping("/profile")
	public String profilePage(Model model, @RequestParam("id") Integer id) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "profile";
	}
	
	
	@GetMapping("/delete")
	public String DeleteUser(Model model, @ModelAttribute("user") User user,
			@AuthenticationPrincipal CustomUserDetails loggedinUser) {


		
		userService.deleteUserProfile(user);
		
		return "redirect:getDashboardPage";
		
	}
	
	//-------------------------------------POST---------------------------------------------------
	
	@PostMapping("/process_signup")
	public String processRegister(User user, HttpServletRequest request)
	            throws UnsupportedEncodingException, MessagingException {
	   userService.register(user, getSiteURL(request));       
	   return "thankyou";
	}
	
	private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }  
	
	@GetMapping("/verify")
	public String verifyUser(@Param("code") String code) {
	    if (userService.verify(code)) {
	        return "verify_success";
	    } else {
	        return "verify_fail";
	    }
	}
	
	@PostMapping("/update-profile")
	public String UpdateUser(Model model, @ModelAttribute("user") User user,
			@AuthenticationPrincipal CustomUserDetails loggedinUser) {

		if(user.getUsername() != loggedinUser.getUsername()) {
			loggedinUser.setUsername(user.getUsername());
		}
		
		userService.updateUserProfile(user);
		
		return "redirect:getDashboardPage";
		
	}
	
	@PostMapping("/dashboard")
	public void search(Model model, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		List<User> users = userService.search(keyword);
		Integer count = users.size();
		
		model.addAttribute("count", count);
		model.addAttribute("users", users);
		//return "dashboard";
	}
	
	//Forgot Password
	@GetMapping("/forgot_password")
	public String showForgotPasswordForm() {
	    return "forgot_password_form";
	}
 
	@PostMapping("/forgot_password")
	public String processForgotPassword(HttpServletRequest request, Model model) {
	    String email = request.getParameter("email");
	    String token = RandomString.make(30);
	     
	    try {
	    	userService.updateResetPasswordToken(token, email);
	        String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
	        sendEmail(email, resetPasswordLink);
	        model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
	         
	    } catch (UsernameNotFoundException ex) {
	        model.addAttribute("error", ex.getMessage());
	    } catch (UnsupportedEncodingException | MessagingException e) {
	        model.addAttribute("error", "Error while sending email");
	    }
	         
	    return "forgot_password_form";
	}
	
	public static class Utility {
	    public static String getSiteURL(HttpServletRequest request) {
	        String siteURL = request.getRequestURL().toString();
	        return siteURL.replace(request.getServletPath(), "");
	    }
	}
     
	public void sendEmail(String recipientEmail, String link)
	        throws MessagingException, UnsupportedEncodingException {
	    MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom("abc_job_community@s.com", "Customer Service");
	    helper.setTo(recipientEmail);
	     
	    String subject = "Here's the link to reset your password";
	     
	    String content = "<p>Hello,</p>"
	            + "<p>You have requested to reset your password.</p>"
	            + "<p>Click the link below to change your password:</p>"
	            + "<p><a href=\"" + link + "\">Change my password</a></p>"
	            + "<br>"
	            + "<p>Ignore this email if you do remember your password, "
	            + "or you have not made the request.</p>";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
	}
     
     
	@GetMapping("/reset_password")
	public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
		User user = userService.getByResetPasswordToken(token);
	    model.addAttribute("token", token);
	     
	    if (user == null) {
	    	return "reset_fail";
	    }
	     
	    return "reset_password_form";
	}
     
	@PostMapping("/reset_password")
	public String processResetPassword(HttpServletRequest request, Model model) {
	    String token = request.getParameter("token");
	    String password = request.getParameter("password");
	     
	    User user = userService.getByResetPasswordToken(token);
	    model.addAttribute("title", "Reset your password");
	     
	    if (user == null) {
	    	
	        
	        return "reset_fail";
	        
	    } else {           
	    	userService.updatePassword(user, password);
	    }
	     
	    return "reset_success";
	}
	


}
