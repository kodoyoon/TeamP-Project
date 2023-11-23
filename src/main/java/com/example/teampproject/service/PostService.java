package com.example.teampproject.service;

import com.example.teampproject.entity.PostEntity;
import com.example.teampproject.dto.PostRequestDto;
import com.example.teampproject.dto.PostResponseDto;
import com.example.teampproject.repository.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostJpaRepository postRepository;
    public PostResponseDto createPost(PostRequestDto requestDto) {
        PostEntity postEntity = new PostEntity(requestDto);
        PostEntity savePost = postRepository.save(postEntity);

        return new PostResponseDto(savePost);
    }

    public PostResponseDto getPost(Long postId){
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new NullPointerException("해당 게시글을 찾을 수 없습니다."));

        return new PostResponseDto(postEntity);
    }
}
