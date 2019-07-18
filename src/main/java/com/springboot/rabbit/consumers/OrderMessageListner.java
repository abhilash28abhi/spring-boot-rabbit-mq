package com.springboot.rabbit.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.springboot.rabbit.config.RabbitMqConfiguration;
import com.springboot.rabbit.message.Order;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class OrderMessageListner {
	
	@RabbitListener(queues = RabbitMqConfiguration.QUEUE_NAME)
    public void processOrder(Order order) {
		log.info("Order recieved from queue is : {}", order);
	}
}
