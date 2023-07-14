package com.solvedex.solvedex.controller;

import com.solvedex.solvedex.entity.BlogPost;
import com.solvedex.solvedex.entity.User;
import com.solvedex.solvedex.repository.BlogRepository;
import com.solvedex.solvedex.repository.CommentRepository;
import com.solvedex.solvedex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private BlogRepository blogPostRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/posts")
    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<BlogPost> getPostById(@PathVariable(value = "id") Long postId) {
        BlogPost post = blogPostRepository.findById(postId).orElse(null);
        if (post != null) {
            return ResponseEntity.ok().body(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/posts")
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost post) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        post.setAuthor(user);
        BlogPost savedPost = blogPostRepository.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<BlogPost> updatePost(
            @PathVariable(value = "id") Long postId,
            @RequestBody BlogPost postDetails
    ) {
        BlogPost post = blogPostRepository.findById(postId).orElse(null);
        if (post != null) {
            post.setTitle(postDetails.getTitle());
            post.setContent(postDetails.getContent());
            BlogPost updatedPost = blogPostRepository.save(post);
            return ResponseEntity.ok().body(updatedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long postId) {
        BlogPost post = blogPostRepository.findById(postId).orElse(null);
        if (post != null) {
            blogPostRepository.delete(post);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
