package com.spring.integrationwith.activemq.handler;

import com.spring.integrationwith.activemq.model.Order;

public interface JmsClient {

	void send(Order msg);

	Order receive();
}
