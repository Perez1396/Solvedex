package com.solvedex.solvedex.repository;

import com.solvedex.solvedex.entity.UserA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserA, Long> {
    UserA findByUsername(String username);
}
