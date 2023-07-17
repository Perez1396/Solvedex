package com.solvedex.solvedex.service;

import com.solvedex.solvedex.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);

    Comment getCommentById(Long id);

    List<Comment> getAllComments();

    Comment updateComment(Long id, Comment comment);

    void deleteComment(Long id);
}
