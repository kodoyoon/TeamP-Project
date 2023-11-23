package com.example.teampproject.controller;

import com.example.teampproject.dto.PostRequestDto;
import com.example.teampproject.dto.PostResponseDto;
import com.example.teampproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    //게시글 작성
    @PostMapping("/posts/create")
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponseDto addPost(@RequestBody PostRequestDto postingRequestDto) {
        return postService.createPost(postingRequestDto);
    }
    //postId로 게시글 조회
    @GetMapping("/posts/{postId}")
    public PostResponseDto getPost(@PathVariable Long postId){
        return postService.getPost(postId);
    }
    //모든 게시글 조회
    @GetMapping("/main")
    public List<PostResponseDto> getPosts(){
        return postService.getPosts();
    }
}
