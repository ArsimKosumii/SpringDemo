package com.model;

public class LoginDTO {
	private String username;
	private String password;
	private String accessToken;
	
	public LoginDTO(String username, String password, String token) {
		this.username = username;
		this.password = password;
		this.accessToken = token;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getaccessToken() {
		return accessToken;
	}
	
	public void setaccessToken(String token) {
		this.accessToken = token;
	}
	
	public boolean equals(Object o) {
		if(o instanceof LoginDTO) {
			return ((LoginDTO)o).getUsername().equals(username);
		}
		return false;
	}
}
