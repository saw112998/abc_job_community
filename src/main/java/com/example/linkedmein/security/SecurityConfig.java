package com.example.linkedmein.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.linkedmein.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		
		auth.setUserDetailsService(userDetailsService());
		auth.setPasswordEncoder(passwordEncoder());
		
		return auth;
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests()
				.antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers(HttpMethod.GET, "/assets/**").permitAll()
				.antMatchers(HttpMethod.GET, "/images/**").permitAll()
				.antMatchers(HttpMethod.GET, "/getHomePage").permitAll()
				.antMatchers(HttpMethod.GET, "/getSignUp").permitAll()
				.antMatchers(HttpMethod.GET, "/thankyou").permitAll()
				.antMatchers(HttpMethod.GET, "/verify").permitAll()
				.antMatchers(HttpMethod.GET, "/getDashboardPage").permitAll()
				.antMatchers(HttpMethod.GET, "/profile").permitAll()			
				.antMatchers(HttpMethod.GET, "/dashboard").permitAll()
				.antMatchers(HttpMethod.GET, "/forgot_password").permitAll()
				.antMatchers(HttpMethod.GET, "/reset_password").permitAll()
				.antMatchers(HttpMethod.GET, "/reset_success").permitAll()
				.antMatchers(HttpMethod.GET, "/jobs").permitAll()
				.antMatchers(HttpMethod.GET, "/add_jobs").permitAll()
				.antMatchers(HttpMethod.GET, "/edit_jobs").permitAll()
				.antMatchers(HttpMethod.GET, "/delete").permitAll()
				.antMatchers(HttpMethod.GET, "/delete_jobs").permitAll()
				
				.antMatchers(HttpMethod.POST, "/process_signup").permitAll()
				.antMatchers(HttpMethod.POST, "/update-profile").permitAll()
				.antMatchers(HttpMethod.POST, "/update-jobs").permitAll()
				.antMatchers(HttpMethod.POST, "/dashboard").permitAll()
				.antMatchers(HttpMethod.POST, "/search_jobs").permitAll()
				.antMatchers(HttpMethod.POST, "/forgot_password").permitAll()
				.antMatchers(HttpMethod.POST, "/reset_password").permitAll()
				.antMatchers(HttpMethod.POST, "/process_add_jobs").permitAll()
				.antMatchers(HttpMethod.POST, "/jobs").permitAll()
				
				
				
				.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/signin")
					.loginProcessingUrl("/login")
					.usernameParameter("email")
					.defaultSuccessUrl("/getDashboardPage")
					.permitAll()
					.and()
				.logout()
					.invalidateHttpSession(true)
					.permitAll();

		
		return http.build();
	}

}