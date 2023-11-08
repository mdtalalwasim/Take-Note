package com.mdtalalwasim.takenote.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mdtalalwasim.takenote.entity.User;
import com.mdtalalwasim.takenote.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		}else {
			return new CustomUser(user);//custom user class constructor.
		}
		
		
	}

}
