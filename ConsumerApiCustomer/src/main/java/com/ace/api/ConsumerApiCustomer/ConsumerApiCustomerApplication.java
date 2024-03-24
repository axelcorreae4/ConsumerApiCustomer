package com.ace.api.ConsumerApiCustomer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApiCustomerApplication {
	private final Logger log = LoggerFactory.getLogger(ConsumerApiCustomerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApiCustomerApplication.class, args);
	}
}
