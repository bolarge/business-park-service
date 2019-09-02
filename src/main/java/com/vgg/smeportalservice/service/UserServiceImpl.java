package com.vgg.smeportalservice.service;

import com.vgg.smeportalservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.vgg.smeportalservice.model.User;
import com.vgg.smeportalservice.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void saveUser(User user) throws Exception {

        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            throw new Exception("User must have at least a role set!");
        }

        for (Role role : user.getRoles()) {
            if (!role.getName().startsWith("ROLE_")) {
                role.setName("ROLE_" + role.getName());
            }

            if (role.getUser() == null) {
                role.setUser(user);
            }
        }

        userRepository.save(user);
    }
}
