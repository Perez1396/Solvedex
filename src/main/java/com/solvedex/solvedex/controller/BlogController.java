package com.solvedex.solvedex.controller;

import com.solvedex.solvedex.entity.BlogPost;
import com.solvedex.solvedex.model.BlogResponseDTO;
import com.solvedex.solvedex.repository.UserRepository;
import com.solvedex.solvedex.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog/posts")
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public List<BlogResponseDTO> getAllPosts() {
        return blogService.getAllBlogPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getPostById(@PathVariable(value = "id") Long postId) {
        BlogPost post = blogService.getBlogPostById(postId);
        if (post != null) {
            return ResponseEntity.ok().body(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost post) {
        BlogPost savedPost = blogService.createBlogPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BlogPost> updatePost(
            @PathVariable(value = "id") Long postId,
            @RequestBody BlogPost postDetails
    ) {
        BlogPost updatedPost = blogService.updateBlogPost(postId, postDetails);
        if (updatedPost != null) {
            return ResponseEntity.ok().body(updatedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long postId) {
            blogService.deleteBlogPost(postId);
            return ResponseEntity.ok().build();
    }
}
