package com.netdeal.crud.createpassword.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.netdeal.crud.createpassword.model.User;

@Component
public interface UserService {
	
    void createUser(User user);
    void updateUser(User user, String id);
    void deleteUser(String id);
    List<User> readAllUsers();
    Optional<User> findUserById(String id);
    
}
