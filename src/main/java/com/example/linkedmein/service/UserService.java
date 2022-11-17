package com.example.linkedmein.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.linkedmein.entity.User;
import com.example.linkedmein.repository.UserRepository;

import net.bytebuddy.utility.RandomString;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//default constructor
	public UserService(UserRepository userRepo) {
		this.userRepository = userRepo;
	}
	
	@Autowired
    private PasswordEncoder passwordEncoder;
     
    @Autowired
    private JavaMailSender mailSender;
	
	// save, update user object
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	//verification
    public void register(User user, String siteURL) 
    		throws UnsupportedEncodingException, MessagingException {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         
        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setEnabled(false);
         
        userRepository.save(user);
        
        sendVerificationEmail(user, siteURL);
       
	     
	 }
    
	private void sendVerificationEmail(User user, String siteURL) 
			throws MessagingException, UnsupportedEncodingException {
	    String toAddress = user.getEmail();
	    String fromAddress = "yexuan10024@gmail.com";
	    String senderName = "ABC Job Community";
	    String subject = "Please verify your registration";
	    String content = "Dear [[name]],<br>"
	            + "Please click the link below to verify your registration:<br>"
	            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
	            + "Thank you,<br>"
	            + "Your company name.";
	    
	    
	     
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom(fromAddress, senderName);
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    content = content.replace("[[name]]", user.getUsername());
	    String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();
	     
	    content = content.replace("[[URL]]", verifyURL);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
	     
	    }
	
	public boolean verify(String verificationCode) {
	    User user = userRepository.findByVerificationCode(verificationCode);
	     
	    if (user == null || user.isEnabled()) {
	        return false;
	    } else {
	        user.setVerificationCode(null);
	        user.setEnabled(true);
	        userRepository.save(user);
	        return true;
	    }
	     
	}
	
	//update user object 
	public void updateUserProfile(User tmp) {
		User user = userRepository.findById(tmp.getId()).get();
		
		user.setUsername(tmp.getUsername());
		user.setEmail(tmp.getEmail());
		user.setFirstname(tmp.getFirstname());
		user.setLastname(tmp.getLastname());
		user.setCompany(tmp.getCompany());
		user.setCity(tmp.getCity());
		user.setCountry(tmp.getCountry());
		
		userRepository.save(user);
		
	}
	
	public void deleteUserProfile(User tmp) {
		User user = userRepository.findById(tmp.getId()).get();

		
		userRepository.delete(user);
		
	}
	
	//Forgot Password
	
    public void updateResetPasswordToken(String token, String email) throws UsernameNotFoundException {
    	User user = userRepository.findByEmail(email);
        if (user != null) {
        	user.setResetPasswordToken(token);
        	userRepository.save(user);
        } else {
            throw new UsernameNotFoundException("Could not find any customer with the email " + email);
        }
    }
	
    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }
    
    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
         
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }
	
    // return all user's information, but hey, we may want to retrieve all except password right?! think about it!
	public List<User> retrieveAllUserProfile() {
	return userRepository.findAll();
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
	
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}
	
	public User getUserByFirstname(String firstname) {
		return userRepository.findUserByFirstname(firstname);
	}
	
	public User getUserByLastname(String lastname) {
		return userRepository.findUserByLastname(lastname);
	}
	
	public List<User> search(String keyword) {
		return userRepository.search(keyword);
	}
}
