package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.repository.UserRepository;
import com.user.model.User;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	 UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> add(@RequestBody User user) {
			userRepository.save(user);
			return new ResponseEntity<>(HttpStatus.CREATED);
	
		}
	
	@RequestMapping(value="/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> login(@RequestBody User user) { 
			userRepository.save(user);
			return new ResponseEntity<>(HttpStatus.CREATED);
	
		}
	}

