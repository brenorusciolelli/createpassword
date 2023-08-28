package com.netdeal.crud.createpassword.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.netdeal.crud.createpassword.model.User;
import com.netdeal.crud.createpassword.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userFacade;
	
	
	@PostMapping
	public ResponseEntity<User> createUserAndPassword(@RequestBody User user) {
		//return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

}
