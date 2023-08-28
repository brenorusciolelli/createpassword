package com.netdeal.crud.createpassword.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "senha")
@Data
public class Password {
	
    @Id
    private String id;
    private String senha;
    private int score;

}
