package com.misyn.webflux;

import com.misyn.webflux.entity.Customer;
import com.misyn.webflux.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class WebFluxMysqlApplicationTests {

	@Autowired
	private CustomerRepository repository;

	@Test
	void contextLoads() {
		System.out.println("XXXXXXXXXX");
		 repository.findAll().flatMap(customer -> {
			System.out.println(customer.getName());
			return Flux.just(new Customer());
		}).log();
	}

}
