package com.netdeal.crud.createpassword.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.netdeal.crud.createpassword.model.User;
import com.netdeal.crud.createpassword.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@PostMapping("/create")
	public ResponseEntity<User> createUserAndPassword(@RequestBody User user) {
		service.createUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<User> findUserById(@RequestParam String id, Model model) {
	var response  = service.findUserById(id);
	model.addAttribute("user", response);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@GetMapping("/listAll")
	public String listAll(Model model) {
	var response  = service.readAllUsers();
	model.addAttribute("list", response);
		return "list_user";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

}
