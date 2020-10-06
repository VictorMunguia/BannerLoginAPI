package com.login.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.controllers.LoginController;
import com.login.domain.UserDTO;
import com.login.domain.UserIdDTO;
import com.login.model.User;
import com.login.repository.LoginRepository;
import com.login.transformer.LoginTransformer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LoginTransformer loginTransformer;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 

	@Override
	public List<User> getUsers() {
		List<User> users = loginRepository.findAll();
		return users;
	}

	@Override
	public UserIdDTO createUser(UserDTO userDTO) {
		if(userDTO.getActive() == null) {
			userDTO.setActive(1);
		}
		
		userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		String id = loginRepository.save(loginTransformer.transformer(userDTO)).getId();
		log.info("User created: " + userDTO);
		return new UserIdDTO(id);
	}

}
