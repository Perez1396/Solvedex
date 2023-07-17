package com.solvedex.solvedex.service.impl;

import com.solvedex.solvedex.entity.UserA;
import com.solvedex.solvedex.repository.UserRepository;
import com.solvedex.solvedex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean findByUsername(String username) {
        UserA userA = userRepository.findByUsername(username);
        return userA != null;
    }

    @Override
    public UserA createUser(UserA userA) {
        String encodedPassword = passwordEncoder.encode(userA.getPassword());
        userA.setPassword(encodedPassword);
        return userRepository.save(userA);
    }
}
