package com.login.services;

import java.util.List;

import com.login.domain.UserDTO;
import com.login.domain.UserIdDTO;
import com.login.model.User;

public interface LoginService {
	
	public List<User> getUsers();
	public UserIdDTO createUser(UserDTO userDTO);

}
