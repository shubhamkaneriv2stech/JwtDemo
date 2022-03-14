package com.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jwt.helper.JwtUtil;
import com.jwt.service.CustomUserDetailsService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// get jwt
		// Bearer
		// validate

		String requestTokenHeader = request.getHeader("Authorization");
		System.out.println(requestTokenHeader);

		
		//Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTaHViaGFtIiwiZXhwIjoxNjM2NTc3MTAwLCJpYXQiOjE2MzY1NDExMDB9.0nMtnb3t8ZIUiBb4f89ZB23A77vwdskjWYUiOtXICBo
		String username = null;

		String jwtToken = null;

		// Null and Format
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {

			jwtToken = requestTokenHeader.substring(7);

			try {

				username = jwtUtil.extractUsername(jwtToken);
				System.out.println(username);
			} catch (Exception e) {

				e.printStackTrace();

			}
			UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
			// security
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			} else {
				System.out.println("Token is not Validated");
			}
		}

		
		System.out.println(request +" "+response.getHeader(""));
		filterChain.doFilter(request, response);

	}

}




//
//
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//	@Autowired
//	
//	private JwtUtil jwtUtil;
//
//	@Autowired
//	private CustomUserDetailsService customUserDetailsService;
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws ServletException, IOException {
//		final String requestTokenHeader = request.getHeader("Authorization");
//		String username = null;
//		String jwtToken = null;
//		// JWT Token is in the form "Bearer token". Remove Bearer word and get
//		// only the Token
//		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//			jwtToken = requestTokenHeader.substring(7);
//			try {
//				//username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//				
//				
//				username=jwtUtil.extractUsername(jwtToken);
//			} catch (IllegalArgumentException e) {
//				System.out.println("Unable to get JWT Token");
//			} catch (ExpiredJwtException e) {
//				System.out.println("JWT Token has expired");
//			}
//		} else {
//			logger.warn("JWT Token does not begin with Bearer String");
//		}
//		// Once we get the token validate it.
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
//			// if token is valid configure Spring Security to manually set
//			// authentication
//		
//				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//						userDetails, null, userDetails.getAuthorities());
//				usernamePasswordAuthenticationToken
//						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				// After setting the Authentication in the context, we specify
//				// that the current user is authenticated. So it passes the
//				// Spring Security Configurations successfully.
//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//			
//		}
//		chain.doFilter(request, response);
//	}
//}
