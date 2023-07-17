package com.solvedex.solvedex.service.impl;

import com.solvedex.solvedex.entity.Comment;
import com.solvedex.solvedex.repository.CommentRepository;
import com.solvedex.solvedex.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(Comment comment) {
        comment.setCreatedAt(new Date());
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        Optional<Comment> existingComment = commentRepository.findById(id);
        if (existingComment.isPresent()) {
            Comment updatedComment = existingComment.get();
            updatedComment.setContent(comment.getContent());
            return commentRepository.save(updatedComment);
        }
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
