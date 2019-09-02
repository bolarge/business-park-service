package com.vgg.smeportalservice.repository;

import org.springframework.dao.DataAccessException;
import com.vgg.smeportalservice.model.User;

public interface UserRepository {

    void save(User user) throws DataAccessException;
}
