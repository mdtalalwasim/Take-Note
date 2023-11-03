package com.mdtalalwasim.takenote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
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
