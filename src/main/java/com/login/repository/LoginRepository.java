package com.login.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.login.model.User;
import com.login.security.service.model.UserSecurity;

@Repository
public interface LoginRepository extends MongoRepository<User, String> {
	UserSecurity findByUsername(@Param("username") String username);

}
