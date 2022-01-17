package com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Comments;
import com.api.repository.CommentsRepository;

@RestController
public class CommentsController {
	@Autowired
	private CommentsRepository comRepo;
	
	@PostMapping(value="/add-comment", consumes="application/json")
	public ResponseEntity<Comments> add(@RequestBody Comments entity) {
		this.comRepo.save(entity);
		
		Comments newComment = entity;
		return new ResponseEntity<>(newComment, HttpStatus.CREATED);
	}
}
