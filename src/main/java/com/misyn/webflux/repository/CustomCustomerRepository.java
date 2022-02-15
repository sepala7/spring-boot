package com.misyn.webflux.repository;

import com.misyn.webflux.dto.OrderCustomerDto;
import com.misyn.webflux.entity.Customer;
import com.misyn.webflux.entity.OrderCustomer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CustomCustomerRepository {
    Flux<OrderCustomerDto> findAllCustomer (Long orderId);
}
