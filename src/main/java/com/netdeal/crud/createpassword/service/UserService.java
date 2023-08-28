package com.netdeal.crud.createpassword.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netdeal.crud.createpassword.exception.DatabaseException;
import com.netdeal.crud.createpassword.exception.NotFoundException;
import com.netdeal.crud.createpassword.exception.ValidationException;
import com.netdeal.crud.createpassword.model.User;
import com.netdeal.crud.createpassword.repository.UserRepository;
import com.netdeal.crud.createpassword.utils.PasswordStatus;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public void createUser(User user) {
		try {
			User obj = new User();
			if(user.getName() != "" || user.getName() != null) {
				obj.setName(user.getName());
				obj.setPassword(user.getPassword());
				var statusPassword = checkStatusPassword(user);
				obj.setPasswordStatus(statusPassword);
				obj.setScore(user.getScore());
				repository.save(obj);
			} else {
				throw new ValidationException("Username null or empty");
			}

		} catch (Exception e) {
			throw new DatabaseException("An error occurred while creating the user", e);
		}

	}
	
	public void updateUser(User user,String id ) {
        try {
    		User existingUser = repository.findById(id).orElse(null);
    		
            if (existingUser != null) {
                BeanUtils.copyProperties(user, existingUser, "id");
                repository.save(existingUser);
            } else {
            	throw new NotFoundException("User with ID " + id + " not found");
            }

		} catch (Exception e) {
			throw new DatabaseException("An error occurred while updating the user", e);
		}
	}
	
	public void deleteUser(String id) {
		try {
			User existingUser = repository.findById(id).orElse(null);
			
	        if (existingUser != null) {
	            repository.deleteById(id);
	        } else {
	        	throw new NotFoundException("User with ID " + id + " not found");
	        }
		} catch (Exception e) {
			throw new DatabaseException("An error occurred while deleting the user", e);
		}
	}
	
    public List<User> readAllUsers() {
        return repository.findAll();
    }
    
    public Optional<User> findUserById(String id ) {
		try {
			User existingUser = repository.findById(id).orElse(null);
			
	        if (existingUser != null) {
	            Optional<User> res = repository.findById(id);
	            return res;
	        } else {
	        	throw new NotFoundException("User with ID " + id + " not found");
	        }
		} catch (Exception e) {
			throw new DatabaseException("An error occurred while finding the user by id:" + id, e);
		}
    }
    
    public PasswordStatus checkStatusPassword(User user) {
    	PasswordStatus status = PasswordStatus.getStatus(user.getPasswordStatus());
		return status;
    }

}
