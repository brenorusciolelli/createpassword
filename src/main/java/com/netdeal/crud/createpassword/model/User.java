package com.netdeal.crud.createpassword.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "usuario")
@Data
public class User {
	
    @Id
    private String id;
    private String nome;
    private String senha;
    private int score;
    
}
