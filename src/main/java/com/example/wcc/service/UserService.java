package com.example.wcc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.wcc.model.User;
import com.example.wcc.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User addUser(String username, String password) {
		User user = new User();
		
		Optional<User> checkUserExist = userRepository.findByUsername(username);
		
		if (checkUserExist.isEmpty()) {
			user.setUsername(username);
			user.setPassword(passwordEncoder.encode(password));
			return userRepository.save(user);
		} else {
			return null;
		}
	}
}
