package com.misyn.webflux.controller;

import com.misyn.webflux.entity.Customer;
import com.misyn.webflux.repository.CustomerRepository;
import com.misyn.webflux.service.Details;
import com.misyn.webflux.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/customer")
public class CustomerApi {

    @Autowired
    CustomerRepository repository;
    @Autowired
    MyService myService;

    @GetMapping
    public Flux<Customer> getCustomers() {
        return repository.findAll().log();
    }

    @GetMapping("/{id}")
    public Mono<Details> getCustomer(@PathVariable Long id) {
     /*   myService.someRestCall("").doOnSuccess(details -> {
            System.out.println(details.toString());
        });*/
        return myService.someRestCall("");
    }

    @PostMapping
    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        Mono<Customer> customerMono=Mono.just(customer).map(customer1 -> {
            customer1.setNic("6666");
            return customer1;
        }).flatMap(customer1 ->repository.save(customer) );
        return repository.save(customer);
    }

    @PutMapping("/{id}")
    public Mono<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        return repository.findById(id)
                .map((c) -> {
                    c.setName(customer.getName());
                    return c;
                }).flatMap(c -> repository.save(c));

    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCustomer(@PathVariable Long id) {
        return repository.deleteById(id);
    }

}
