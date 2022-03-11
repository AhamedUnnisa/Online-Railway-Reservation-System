package com.example.user.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.user.model.User;
import com.example.user.repo.UserRepo;
//import com.example.user.service.SequenceGeneratorService;

@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	UserRepo userRepo;
	
	 
	
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") int id) {
		return userRepo.findById(id).get();
	}
	
	@PutMapping("/update")
	public void updateUser(@RequestBody User user) {
		userRepo.save(user);
	}
	
	@DeleteMapping("/del/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userRepo.deleteById(id);
	}
	
}