package com.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.User;
import com.movie.repository.UserRepository;

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

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> add(@RequestBody User user) {
		Map<String, String> response = new HashMap<String, String>();
		if (user.getUserName() == null) {
			response.put("error", "Please Enter valid UserName");
			return ResponseEntity.badRequest().body(response);
		} else if (user.getEmailId() == null) {
			response.put("error", "Please Enter valid EmailId");
			return ResponseEntity.badRequest().body(response);
		} else if (user.getPassword() == null) {
			response.put("error", "Please Enter valid Password");
			return ResponseEntity.badRequest().body(response);
		} else {
			userRepository.save(user);
			response.put("ok", "Registered Succesfuly");
			return ResponseEntity.accepted().body(response);
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
		Map<String, String> response = new HashMap<String, String>();
		String email = String.valueOf(user.getEmailId());
		String password = String.valueOf(user.getPassword());
		if ((userRepository.findOneByEmailId(email) != null) && (userRepository.findOneByPassword(password) != null)) {
			response.put("ok", "Logedin Succesfuly");
			return ResponseEntity.accepted().body(response);
		} else {
			response.put("error", "LogIn Failed! Please Enter valid Email and Password");
			return ResponseEntity.badRequest().body(response);
		}

	}
}
