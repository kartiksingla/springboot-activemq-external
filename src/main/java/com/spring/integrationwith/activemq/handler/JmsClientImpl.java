package com.spring.integrationwith.activemq.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.integrationwith.activemq.consumer.OrderConsumer;
import com.spring.integrationwith.activemq.model.Order;
import com.spring.integrationwith.activemq.producer.OrderProducer;

@Service
public class JmsClientImpl implements JmsClient {

	@Autowired
	OrderConsumer orderConsumer;

	@Autowired
	OrderProducer orderProducer;

	public void send(Order order) {
		orderProducer.sendTopic(order);
	}

	@Override
	public Order receive() {
		return orderConsumer.receive();
	}

}
