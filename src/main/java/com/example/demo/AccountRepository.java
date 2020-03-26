package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface AccountRepository extends ReactiveCrudRepository<Account, String> {

    Mono<Account> findByUserIdentifier(String userIdentifier);
}
