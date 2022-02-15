package com.misyn.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebFluxMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFluxMysqlApplication.class, args);
	}

}
