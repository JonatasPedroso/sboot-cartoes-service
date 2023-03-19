package dev.jonataspedroso.sbootcartoesservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class SbootCartoesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootCartoesServiceApplication.class, args);
	}

}
