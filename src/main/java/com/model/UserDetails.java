package com.model;

public class UserDetails {
	private String name;
	private String lastname;
	private int age;
	private String username;
	
	public UserDetails(String name, String lastname, int age, String username) {
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean equals(Object o) {
		if(o instanceof UserDetails) {
			return ((UserDetails)o).getUsername().equals(username);
		}
		return false;
	}

}
