package com.jwt;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jwt.model.User;
import com.jwt.repo.UserRepository;

@SpringBootApplication
public class JwtDemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	static Random random = new Random();

	public void createUsers() {
		User user = new User();
	

		
		user.setPassword(passwordEncoder.encode("Shubham"));
		user.setUsername("Shubham@gmail.com");
		user.setEnabled(false);
		

		User save = userRepository.save(user);
		System.out.println(save);
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		//createUsers();

	}

}
