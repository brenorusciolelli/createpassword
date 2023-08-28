package com.netdeal.crud.createpassword.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netdeal.crud.createpassword.model.User;
import com.netdeal.crud.createpassword.service.UserServiceImpl;
import com.netdeal.crud.createpassword.utils.PasswordStatus;

@Service
public class UserFacade {
	
	@Autowired
	UserServiceImpl service;
	
	public void createUser(User user) {
		PasswordStatus valueStatus = evaluatePasswordStrength(user.getPassword());
		String score = getScorePassword(valueStatus);
		user.setScore(score);
		user.setPasswordStatus(valueStatus);
		service.createUser(user);
	}
	
	public List<User> listAll() {
		return service.readAllUsers();
	}
	
    public PasswordStatus evaluatePasswordStrength(String password) {
        if (password.length() < 6) {
            return PasswordStatus.RUIM;
        } else if (password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).*")) {
            return PasswordStatus.FORTE;
        } else if (password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*")) {
            return PasswordStatus.BOM;
        } else if (password.matches("(?=.*[a-z])(?=.*\\d).*")) {
            return PasswordStatus.MEDIANA;
        } else {
            return PasswordStatus.RUIM;
        }
    }
    
    public String getScorePassword(PasswordStatus password) {
        String score;
        switch (password) {
            case RUIM: 
                score = "20";
                break;
            case MEDIANA: 
                score = "50";
                break;    
            case BOM: 
                score = "70";
                break; 
            case FORTE: 
                score = "100";
                break; 
            default:
                score = "0";
                break;
        }
        return score;
    }
}