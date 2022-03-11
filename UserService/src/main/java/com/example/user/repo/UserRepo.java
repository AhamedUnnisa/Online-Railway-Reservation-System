package com.example.user.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.user.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, Integer>{
	User findByUsername(String username);
}