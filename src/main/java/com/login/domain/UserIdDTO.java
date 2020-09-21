package com.login.domain;

import lombok.Data;

@Data
public class UserIdDTO {
	
	public UserIdDTO(String id) {
		this.id = id;
	}

	private String id;

}
