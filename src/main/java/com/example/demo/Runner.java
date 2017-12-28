package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	private final RabbitTemplate rabbitTemplate;
	private final ConfigurableApplicationContext context;

	public Runner(RabbitTemplate rabbitTemplate, ConfigurableApplicationContext context) {
		this.rabbitTemplate = rabbitTemplate;
		this.context = context;
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		for(int i = 0; i < 100; i++) {
			System.out.println("Sending message Pedro...");
			rabbitTemplate.convertAndSend(Application.queueName, "Hello from RabbitMQ!");
		}
		context.close();
	}

}