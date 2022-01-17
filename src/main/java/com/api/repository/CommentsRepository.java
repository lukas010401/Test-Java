package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Long>{

}
