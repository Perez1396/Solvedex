package com.solvedex.solvedex.repository;

import com.solvedex.solvedex.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
