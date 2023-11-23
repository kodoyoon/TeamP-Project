package com.example.teampproject.repository;

import com.example.teampproject.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostJpaRepository extends JpaRepository<PostEntity,Long>{
}