package com.solvedex.solvedex.repository;

import com.solvedex.solvedex.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogPost, Long> {
}