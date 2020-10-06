package com.login.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.repository.LoginRepository;
import com.login.security.service.model.UserPrincipal;
import com.login.security.service.model.UserSecurity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserPrincipalDetailsService implements UserDetailsService {
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserSecurity user = loginRepository.findByUsername(username);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		log.info("*TEMPORAL LOG* Principal user Authorities: " + userPrincipal.getAuthorities());
		return userPrincipal;
	}

}
