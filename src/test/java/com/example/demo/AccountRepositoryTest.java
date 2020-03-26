package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class AccountRepositoryTest {

    @Autowired
    AccountRepository repository;
    private String userIdentifier = "123";

    @BeforeEach
    void setUp() {
        repository.deleteAll().block();
        // Create an account
        Account account = new Account(userIdentifier);
        repository.save(account).block();
    }

    @Test
    void findAccount() {
        // Find account
        Account foundAccount = repository.findByUserIdentifier(userIdentifier).block();

        assertThat(foundAccount).isNotNull();
        assertThat(foundAccount.getUserIdentifier()).isEqualTo(userIdentifier);
    }
}