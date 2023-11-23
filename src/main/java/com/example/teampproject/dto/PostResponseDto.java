package com.example.teampproject.dto;

import com.example.teampproject.entity.PostEntity;
public record PostResponseDto (
        Long user_id,
        Long post_id,
        String title,
        String contents
){
    public PostResponseDto(PostEntity post) {
        this(
                post.getPosting_id(),
                post.getUser_id(),
                post.getTitle(),
                post.getContents()
        );
    }
}
