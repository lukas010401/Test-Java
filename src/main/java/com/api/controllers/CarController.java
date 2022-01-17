package com.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Car;
import com.api.repository.CarRepository;
import com.api.repository.CommentsRepository;

@RestController
public class CarController {
	@Autowired
	private CarRepository carRepo;
	
	@Autowired
	private CommentsRepository comRepo;
	
	//USER STATUS => 0 si non-connecté
	@GetMapping("/cars")
	public ResponseEntity<List<?>> get(@RequestParam int userStatus) {
		List<?> carList = new ArrayList<Car>();
		
		if(userStatus == 0) {
			carList = this.carRepo.findAll();
		}
		else{
			carList = this.comRepo.findAll();
		}
		
		return new ResponseEntity<>(carList, HttpStatus.OK);
	}
}
