package com.solvedex.solvedex.service;

import com.solvedex.solvedex.entity.UserA;

public interface UserService {
    Boolean findByUsername(String username);
    UserA createUser(UserA userA);
}
