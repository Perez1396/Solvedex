package com.solvedex.solvedex.service.impl;

import com.solvedex.solvedex.entity.BlogPost;
import com.solvedex.solvedex.repository.BlogRepository;
import com.solvedex.solvedex.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogPostRepository;

    @Override
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public BlogPost getBlogPostById(Long postId) {
        return blogPostRepository.findById(postId).orElse(null);
    }

    @Override
    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public BlogPost updateBlogPost(Long postId, BlogPost postDetails) {
        BlogPost post = blogPostRepository.findById(postId).orElse(null);
        if (post != null) {
            post.setTitle(postDetails.getTitle());
            post.setContent(postDetails.getContent());
            return blogPostRepository.save(post);
        } else {
            return null;
        }
    }

    @Override
    public void deleteBlogPost(Long postId) {
        blogPostRepository.findById(postId).ifPresent(post -> blogPostRepository.delete(post));
    }
}
