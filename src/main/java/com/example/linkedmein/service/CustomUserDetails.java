package com.example.linkedmein.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.linkedmein.entity.User;

public class CustomUserDetails implements UserDetails {
	
	private User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}
	
	public boolean isEnabled1() {
        return user.isEnabled();
    }
	
	public void setUsername(String username) {
		this.user.setUsername(username);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; 
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
