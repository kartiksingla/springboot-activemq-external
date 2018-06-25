package com.spring.integrationwith.activemq.dto;

import java.math.BigDecimal;

public class OrderDto {

	private String from;

	private String to;

	private BigDecimal amount;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
