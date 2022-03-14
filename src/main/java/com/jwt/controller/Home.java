package com.jwt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Home {

	@GetMapping("/welcome")
	public String welcome()
	{
		String text="this is private page";
		text+="this page is not allowed to unauthenticated users";
		return text;
	}
	

	@GetMapping("/getusers")
	public String getusers()
	{
		return "{\"name\":\"Durgesh\"}";
	}
	
	
	
	
	
	
	
	
	
	
}
