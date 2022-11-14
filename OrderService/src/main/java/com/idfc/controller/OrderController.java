package com.idfc.controller;

import com.idfc.model.Order;
import com.idfc.service.OrderServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderServiceImple service;
	
	@PostMapping("/")
	public ResponseEntity<Object> placeOrder(
			//@RequestParam String title,
			//@RequestParam int qty,
			//@RequestParam String name
			@RequestBody Order order
			){
		
		Order res = this.service.placeOrder(order);
		if(res == null)
			return new ResponseEntity<Object>("Not enough quantity", HttpStatus.NOT_FOUND);
		//System.out.println(order);
		return new ResponseEntity<Object>( res, HttpStatus.CREATED);
	}
}
