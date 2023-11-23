package com.example.teampproject.service;

import com.example.teampproject.entity.PostEntity;
import com.example.teampproject.dto.PostRequestDto;
import com.example.teampproject.dto.PostResponseDto;
import com.example.teampproject.repository.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PostResponseDto> getPosts(){
        return postRepository.findAll().stream().
                map(PostResponseDto::new).collect(Collectors.toList());
    }
}
