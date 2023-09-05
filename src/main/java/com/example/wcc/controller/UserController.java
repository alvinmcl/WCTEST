package com.example.wcc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.wcc.model.User;
import com.example.wcc.service.JwtService;
import com.example.wcc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("createUser/{username}/{password}")
	public ResponseEntity<?> createNewUser(@PathVariable String username, @PathVariable String password) {
		Optional<User> result = Optional.ofNullable(userService.addUser(username, password));
		
		if (result.isPresent()) {
			return ResponseEntity.ok(result);
		} else {
			return new ResponseEntity<Object>(new String("something occured or username existed"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/authenticate/{username}/{password}")
	public String authenticateAndGenerateToken(@PathVariable String username, @PathVariable String password) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(username);
		} else {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
	}
}
