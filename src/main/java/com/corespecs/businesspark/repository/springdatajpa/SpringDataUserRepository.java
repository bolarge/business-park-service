package com.corespecs.businesspark.repository.springdatajpa;

import com.corespecs.businesspark.model.User;
import com.corespecs.businesspark.repository.UserRepository;
import org.springframework.data.repository.Repository;

//@Profile("spring-data-jpa")
public interface SpringDataUserRepository extends UserRepository, Repository<User, Integer> {

}
