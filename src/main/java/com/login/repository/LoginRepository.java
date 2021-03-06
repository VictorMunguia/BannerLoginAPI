package com.login.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.login.model.User;

@Repository
public interface LoginRepository extends MongoRepository<User, String> {

}
