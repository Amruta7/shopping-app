package com.shopping.user.dto;

import java.io.Serializable;

//user data transfer object for passing user information between different layers

public class UserDto implements Serializable {

	private static final long serialVersionUID = 5141516800840386498L;
	
	private String userId;
	private String email;
	private String password;
	private String encryptedPassword;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	
	
	
	
	
	

}
