package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jwt.helper.JwtUtil;
import com.jwt.model.JwtRequest;
import com.jwt.model.JwtResponse;
import com.jwt.service.CustomUserDetailsService;

@RestController
@CrossOrigin
public class JwtController {

	
	

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/user/login")
	public ResponseEntity<Object> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println(jwtRequest);

		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
		} 
		catch (BadCredentialsException e) {e.printStackTrace();

		throw new BadCredentialsException("Bad Credentials");
			
		}

		UserDetails userDetails=customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		
		String token = jwtUtil.generateToken(userDetails);
		
		System.out.println("JWT  Token"+token);
		
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body(new  JwtResponse(token));
	}

}
