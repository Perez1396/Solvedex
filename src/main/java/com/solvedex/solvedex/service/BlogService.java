package com.solvedex.solvedex.service;

import com.solvedex.solvedex.entity.BlogPost;
import com.solvedex.solvedex.model.BlogResponseDTO;

import java.util.List;

public interface BlogService {
    List<BlogResponseDTO> getAllBlogPosts();
    BlogPost getBlogPostById(Long postId);
    BlogPost createBlogPost(BlogPost blogPost);
    BlogPost updateBlogPost(Long postId, BlogPost updatedBlogPost);
    void deleteBlogPost(Long postId);
}
