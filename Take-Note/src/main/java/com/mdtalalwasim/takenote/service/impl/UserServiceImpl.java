package com.mdtalalwasim.takenote.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdtalalwasim.takenote.entity.User;
import com.mdtalalwasim.takenote.repository.UserRepository;
import com.mdtalalwasim.takenote.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public User saveUser(User user) {
		user.setRole("ROLE_USER");
		User newUser = this.userRepository.save(user);
		return newUser;
	}

	@Override
	public boolean emailExistOrNot(String email) {
		return this.userRepository.existsByEmail(email);
		
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return this.userRepository.findByEmail(email);
	}
	
	

}
