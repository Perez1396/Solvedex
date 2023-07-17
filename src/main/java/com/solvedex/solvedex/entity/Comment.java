package com.solvedex.solvedex.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "COMMENT")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private BlogPost blogPost;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String content;

    private Date createdAt;
}
