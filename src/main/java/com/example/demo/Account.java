package com.example.demo;

import com.bol.secure.Encrypted;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {
    @Id
    private String id;

    @Encrypted // <- try turning me off and on
    private String userIdentifier;

    public Account(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }
}
