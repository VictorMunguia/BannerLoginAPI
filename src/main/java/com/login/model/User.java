package com.login.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String username;

	private String password;

	private String name;

	private String lastname;

	private String rol;

	private LocalDate birthdaydate;

	private String address;

	private String email;

	private Long phonenumber;
}
