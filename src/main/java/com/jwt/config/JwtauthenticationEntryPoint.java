package com.jwt.config;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class JwtauthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		
		
		
		
		//response.sendError(401,"Unauthorized Person bad crenditals" );
		
		

        final Map<String, Object> mapBodyException = new HashMap<>() ;

//        mapBodyException.put("error"    , "Error from AuthenticationEntryPoint") ;
        mapBodyException.put("message"  , "Credentials do not match") ;
//        mapBodyException.put("exception", "My stack trace exception") ;
//        mapBodyException.put("path"     , request.getServletPath()) ;
//        mapBodyException.put("timestamp", (new Date()).getTime()) ;

        response.setContentType("application/json") ;
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED) ;

        final ObjectMapper mapper = new ObjectMapper() ;
        mapper.writeValue(response.getOutputStream(), mapBodyException) ;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
