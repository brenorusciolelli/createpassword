package com.netdeal.crud.createpassword.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.netdeal.crud.createpassword.facade.UserFacade;
import com.netdeal.crud.createpassword.model.User;

@Controller
public class UserController {

	@Autowired
	UserFacade facade;

	@PostMapping("/create")
	public ResponseEntity<User> createUserAndPassword(@RequestBody User user) {
		facade.createUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
	@GetMapping("/id/{id}")
	public String findUserById(@PathVariable String id, Model model) {
		var user = facade.findUserById(id);
		model.addAttribute("user", user);
		return "modal";
	}

	@GetMapping("/listAll")
	public String listAll(Model model) {
		var response = facade.listAll();
		model.addAttribute("list", response);
		return "list_user";
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable String id) {
		facade.delete(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}

}
