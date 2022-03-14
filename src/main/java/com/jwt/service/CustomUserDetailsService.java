package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.model.CustomUserDetails;
import com.jwt.model.User;
import com.jwt.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//		
//		if (username.equals("Shubham")) {
//			return new User("Shubham", "Shubham123", new ArrayList<>());
//		}
//		else
//		{
//			throw new UsernameNotFoundException("User Not Found");
//		}

		User findByUsername = userRepository.findByUsername(username);

		if (findByUsername == null) {
			throw new BadCredentialsException("Credentials do not match");
		} else {
			return new CustomUserDetails(findByUsername);
		}

	}

}
