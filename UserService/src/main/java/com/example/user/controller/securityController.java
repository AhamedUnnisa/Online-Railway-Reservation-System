package com.example.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.AuthRequest;
import com.example.user.model.AuthResponse;
import com.example.user.model.User;
import com.example.user.repo.UserRepo;
import com.example.user.security.JWT;
import com.example.user.service.*;

@RestController
@RequestMapping("/user")
public class securityController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private userDetailService userDetailService;
	
	@Autowired
	private JWT jwtUtil;
	
	@Autowired
	UserRepo userRepo;
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception{
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username and password", e);
		}
		
		final UserDetails userDetails= userDetailService.loadUserByUsername(authRequest.getUsername());
		 
		final String jwt= jwtUtil.generateToken(userDetails);
		System.out.println(jwt);
		
		User user= userRepo.findByUsername(userDetails.getUsername());
		
		return 	ResponseEntity.ok(new AuthResponse(jwt, user.getId(), user.getName()));
	}
	
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		System.out.println(user);
		List<String> usernames= new ArrayList<>();
		userRepo.findAll().forEach(u-> usernames.add(u.getUsername()));
		
		if(usernames.contains(user.getUsername()))
			return "-1";
	
		user.setRole("USER");
		userRepo.save(user);
		
		return user.getId()+"";
		
	}
	
}