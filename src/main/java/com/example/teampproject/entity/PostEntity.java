package com.example.teampproject.entity;

import com.example.teampproject.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@Table(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long posting_id;
    @Column(nullable = false, length = 20)
    private String title;
    @Column(nullable = false, length = 500)
    private String contents;

    public PostEntity(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
