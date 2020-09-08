package com.corespecs.businesspark.repository;

import org.springframework.dao.DataAccessException;
import com.corespecs.businesspark.model.User;

public interface UserRepository {

    void save(User user) throws DataAccessException;
}
