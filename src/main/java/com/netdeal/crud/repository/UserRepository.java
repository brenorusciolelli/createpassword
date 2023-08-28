package com.netdeal.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.netdeal.crud.createpassword.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
