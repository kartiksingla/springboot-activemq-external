package com.spring.integrationwith.activemq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.spring.integrationwith.activemq.model.Order;

@Component
public class OrderConsumer {

    private static Logger log = LoggerFactory.getLogger(OrderConsumer.class);
    
    @Autowired
    JmsTemplate jmsTemplate;
    
    @Value("${jms.queue.destination}")
    String destinationQueue;

    public Order receive(){
    	return (Order) jmsTemplate.receiveAndConvert(destinationQueue);
    }
    
}
