package com.netdeal.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.netdeal.crud.createpassword.model.Password;

public interface PasswordRepository extends MongoRepository<Password, String> {

}
