package com.mdtalalwasim.takenote.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mdtalalwasim.takenote.entity.User;
import com.mdtalalwasim.takenote.repository.UserRepository;
import com.mdtalalwasim.takenote.service.UserService;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public User saveUser(User user) {
		user.setRole("ROLE_USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
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
	
	//remove Sesstion Message
	public void removeSesstionMessage() {
		HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		session.removeAttribute("message");
	}
	
	

}
