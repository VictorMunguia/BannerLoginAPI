package com.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.login.domain.UserDTO;
import com.login.domain.UserIdDTO;
import com.login.model.User;
import com.login.services.LoginService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/login")
@Slf4j
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(value = "/getuser", produces = "application/json")
	public List<User> getUser() {
		log.info("Calling getUser");
		return loginService.getUsers();
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/createuser",  produces = "application/json")
	public UserIdDTO createUser( @RequestBody UserDTO userDTO) {
		log.info("Calling createUser");
		return loginService.createUser(userDTO);
	}
	
}
