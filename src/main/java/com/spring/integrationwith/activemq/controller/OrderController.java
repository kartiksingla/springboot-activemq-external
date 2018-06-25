package com.spring.integrationwith.activemq.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.integrationwith.activemq.dto.OrderDto;
import com.spring.integrationwith.activemq.handler.JmsClient;
import com.spring.integrationwith.activemq.model.Order;

@RestController
public class OrderController {

	@Autowired
	JmsClient jmsClient;

	@RequestMapping("/produce")
	public String produceMessage(@RequestBody OrderDto orderdto) {
		Order order = new Order();
		BeanUtils.copyProperties(orderdto, order);
		jmsClient.send(order);
		return "SUCCESS";
	}

	@RequestMapping("/receive")
	public Order receive() {
		return jmsClient.receive();
	}

}
