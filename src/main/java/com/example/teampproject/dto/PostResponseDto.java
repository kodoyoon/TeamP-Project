package com.example.teampproject.dto;

import com.example.teampproject.entity.PostEntity;
public record PostResponseDto (
        Long userId,
        Long postId,
        String title,
        String contents
){
    public PostResponseDto(PostEntity post) {
        this(
                post.getPostId(),
                post.getUserId(),
                post.getTitle(),
                post.getContents()
        );
    }
}
