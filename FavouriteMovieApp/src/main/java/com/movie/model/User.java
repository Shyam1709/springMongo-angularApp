package com.movie.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class User {
	private String userName;
	private String emailId;
	private String password;

	public User() {

	}
	public User(String userName,String emailId, String password) {
		this.userName=userName;
		this.emailId=emailId;
		this.password=password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
