package com.mdtalalwasim.takenote.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mdtalalwasim.takenote.entity.User;
import com.mdtalalwasim.takenote.repository.UserRepository;



@Controller
@RequestMapping("/user")//this will only accessible when user is login, as we mention in securityConfig class.
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	//everytime if user is login 
	//@ModelAttribute help to access the below method to every where, for the login user 
	@ModelAttribute
	public void getUser(Principal principal, Model model) {
		String email = principal.getName();
		User user = this.userRepository.findByEmail(email);
		
		model.addAttribute("user",user); //binding to view.
		
		
	}
	
	
	
	@GetMapping("/add-notes")
	public String addNotes() {
		return "add-notes";
	}
	
	@GetMapping("/view-notes")
	public String viewNotes() {
		return "view-notes";
	}
	
	@GetMapping("/edit-notes")
	public String editNotes() {
		return "edit-notes";
	}
}
