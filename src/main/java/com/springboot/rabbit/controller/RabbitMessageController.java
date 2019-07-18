package com.springboot.rabbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rabbit.message.Order;
import com.springboot.rabbit.producers.OrderMessageSender;

@RestController
@RequestMapping(value = "/rabbit")
public class RabbitMessageController {
	
	@Autowired
	private OrderMessageSender messageSender; 
	
	@PostMapping(value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void pushMessage (@RequestBody Order order) {
		messageSender.sendOrder(order);
	}
}
