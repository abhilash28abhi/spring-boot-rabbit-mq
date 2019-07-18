package com.springboot.rabbit.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.rabbit.config.RabbitMqConfiguration;
import com.springboot.rabbit.message.Order;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderMessageSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendOrder(Order order) {
		log.info("Order recieved from controller : {}", order);
		this.rabbitTemplate.convertAndSend(RabbitMqConfiguration.QUEUE_NAME, order);
	}
}
