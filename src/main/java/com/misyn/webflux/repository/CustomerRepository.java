package com.misyn.webflux.repository;

import com.misyn.webflux.entity.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long>,CustomCustomerRepository {
}
