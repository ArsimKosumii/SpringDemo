package com.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.LoginDTO;
import com.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(value = "/auth")
public class LoginController {
	private String secret = "secret";

	@GetMapping("/login")
	public LoginDTO login() {
		User user = new User("arsimkosumi","password");
		String token = this.generateToken(user);
		return new LoginDTO("Arsim", "Kosumi", token);
	}

	@GetMapping("/users")
	public String getAllUsers() {
		return "USERS";
	}

	public String generateToken(User user) {
		return Jwts.builder().setSubject(user.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
}
