package com.login.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDTO {

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
