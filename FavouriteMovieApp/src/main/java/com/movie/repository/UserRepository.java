package com.movie.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.movie.model.User;


public interface UserRepository extends MongoRepository<User, String> {
	public User findOneByEmailId(String emailId);
	public User findOneByPassword(String password);
	
}

