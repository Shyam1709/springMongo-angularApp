package com.user.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class User {
	@NotNull @Size(min=2, max=30) 
	private String userName;
	@NotNull @Email
	private String emailId;
	@NotNull  @Size(min=6, max=10)
	private String password;
	@NotNull  @Size(min=6, max=10)
	private String confirmPassword;

	public User() {

	}
	public User(String userName,String emailId, String password, String confirmPassword) {
		this.userName=userName;
		this.emailId=emailId;
		this.password=password;
		this.confirmPassword=confirmPassword;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
