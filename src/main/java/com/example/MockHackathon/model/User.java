package com.example.MockHackathon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	private String userName;
	private String password;
	@JsonProperty("user_id")
    private String userId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
