package com.netdeal.crud.createpassword.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.netdeal.crud.createpassword.utils.PasswordStatus;

import lombok.Data;

@Document(collection = "usuario")
@Data
public class User {
	
    @Id
    private String id;
    private String name;
    private String password;
    private String score;
    private PasswordStatus passwordStatus;
    
    private int positionValue;
    private Position position;
    private Position superior;
    
    public User(String name, Position position, Position superior) {
        this.name = name;
        this.position = position;
        this.superior = superior;
    }
    
    public User() {
    	
    }
    
}
