package com.solvedex.solvedex.model;

import com.solvedex.solvedex.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BlogResponseDTO {
    private Long id;
    private String title;
    private String content;
    private List<Comment> comments;
}
