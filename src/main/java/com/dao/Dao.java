package com.dao;

import com.model.UserDetails;

public class Dao {
	
	public Dao() {}

	public UserDetails loadUserByUsername(String username) {
		return new UserDetails("Arsim", "Kosumi", 25, "arsimkosumi");
	}
}
