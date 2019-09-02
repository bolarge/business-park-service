package com.vgg.smeportalservice.repository.springdatajpa;

import com.vgg.smeportalservice.model.User;
import com.vgg.smeportalservice.repository.UserRepository;
import org.springframework.data.repository.Repository;

//@Profile("spring-data-jpa")
public interface SpringDataUserRepository extends UserRepository, Repository<User, Integer> {

}
