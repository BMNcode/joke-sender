package org.bmn.jokesender;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableRabbit
@EnableTransactionManagement
public class JokeSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JokeSenderApplication.class, args);
	}

}
