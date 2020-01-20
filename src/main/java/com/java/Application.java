package com.java;


//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Exchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.QueueBuilder;
//import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableJpaRepositories(basePackages="com.java.dao")
@SpringBootApplication
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@Bean
//	public Queue queue() {
//		return QueueBuilder.durable("apply-queue").withArgument("apply", "apply-exchange").build();
//		//return QueueBuilder.durable("apply-queue").build();
//	}
//	
//	@Bean
//	public Exchange exchange() {
//		return new TopicExchange("apply-exchange");
//	}
//	
//	@Bean
//	public Binding binding() {
//		return BindingBuilder.bind(queue()).to(exchange()).with("apply").noargs();
//	}
}
