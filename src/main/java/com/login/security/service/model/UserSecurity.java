package com.login.security.service.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Users")
@Data
public class UserSecurity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String username;

	private String password;

	private String name;

	private String lastname;

	private String roles;

	private LocalDate birthdaydate;

	private String address;

	private String email;

	private Long phonenumber;
	
	private Integer active;
	
	public List<String> getRoleList(){
		if(this.roles.length() > 0) {
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<>();
	}
}
