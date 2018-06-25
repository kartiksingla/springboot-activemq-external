package com.spring.integrationwith.activemq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.spring.integrationwith.activemq.model.Order;

@Component
public class OrderProducer {

	private static Logger log = LoggerFactory.getLogger(OrderProducer.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${jms.queue.destination}")
	String destinationQueue;

	public void sendTopic(Order order) {
		log.info("sending with convertAndSend() to queue <" + order + ">");
		jmsTemplate.convertAndSend(destinationQueue, order);
	}

}
