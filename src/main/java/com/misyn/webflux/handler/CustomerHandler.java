package com.misyn.webflux.handler;

import com.misyn.webflux.dto.OrderCustomerDto;
import com.misyn.webflux.entity.Customer;
import com.misyn.webflux.exception.RecordNotFoundException;
import com.misyn.webflux.repository.CustomerRepository;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    private CustomerRepository repository;

    public CustomerHandler(CustomerRepository repository) {
        this.repository = repository;
    }



    @Transactional
    public Mono<ServerResponse> getCustomers(ServerRequest request) {
        Flux<Customer> customerList = repository.findAll();//.flatMap(this::test);
        customerList.subscribe(customer -> {
            System.out.println(customer);
        });
       // Flux<OrderCustomerDto> customerList = repository.findAllCustomer(1l).log();
       // return ServerResponse.ok().body(customerList, OrderCustomerDto.class);
        return ServerResponse.ok().body(customerList, Customer.class);
    }

   Mono<Customer>  test(Customer customer1){
        customer1.setCustomerType(2);
       Mono<Customer> save = repository.save(customer1);
       customer1.setCustomerType(1);
       return   save.log().then( repository.save(customer1)).doOnSuccess(customer -> {
            System.out.println("Saved");
           customer1.setCustomerType(1);

        });
    //    System.out.println("customer1"+customer1);
   }


    public Mono<ServerResponse> getCustomer(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("id"));
        if (id == null) {
            return Mono.error(new RecordNotFoundException("Customer ID - Null"));
        }
        Mono<Customer> byId = repository.findById(id).switchIfEmpty(Mono.error(new RecordNotFoundException("Customer not found")));

        return byId.flatMap(customer -> {

            System.out.println("========="+customer.getName());

            return ServerResponse.ok().body(byId, Customer.class);}).log()

                .onErrorResume(error -> {
                    if (error instanceof RecordNotFoundException) {
                        return ServerResponse.status(404).bodyValue(error.getMessage());
                    } else {
                        return ServerResponse.status(500).bodyValue(error.getMessage());
                    }
                });
    }

    void setName(Customer customer){
        customer.setName("xxxxxxx");
    }

    public Mono<ServerResponse> getCustomer_(ServerRequest request) {
        Customer newCustomer = new Customer();
        newCustomer.setName("AKILA");
        newCustomer.setNic("921474205V");

        Long id = Long.parseLong(request.pathVariable("id"));

        if (id == null) {
            return Mono.error(new RecordNotFoundException("Cust ID - Null"));
        }

        Mono<Customer> byId = repository.findById(id).defaultIfEmpty(newCustomer).flatMap(customer ->
        {
            if (customer.getCustomerId() == null) {
                return Mono.error(new RecordNotFoundException("Cust ID - Null"));
            } else if (customer.getNic().equals("821484308V")) {
                return Mono.error(new RecordNotFoundException("NIC already avalibale"));
            }
            customer.setName("XXXXXXXXXXXX");
            System.out.println("Customer :->" + customer);
            return Mono.just(customer);
        }).doOnNext(customer -> {
            // customer.setName("Akila SILVA");
        }).doOnSuccess(customer -> {
            System.out.println("Success " + customer);
        });


        //Mono<Customer> byId = Mono.just(new Customer()).log();


        return byId.flatMap(customer -> {
            return ServerResponse.ok().body(byId, Customer.class);
        }).switchIfEmpty(ServerResponse.notFound().build()).onErrorResume(e -> {
            System.out.println("ERROR :" + e.getMessage());
            return ServerResponse.status(404).bodyValue(e.getMessage());
        });
        // return ServerResponse.ok().body(repository.findById(id), Customer.class);
    }


    public Mono<ServerResponse> createCustomer(ServerRequest request) {
        Mono<Customer> customerMono = request.bodyToMono(Customer.class);
        Mono<Customer> saveResponse = customerMono.flatMap(repository::save);
        return ServerResponse.ok().body(saveResponse, Customer.class);
    }


    @Transactional
    public Mono<ServerResponse> updateCustomer(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("id"));
        Mono<Customer> customerMono = request.bodyToMono(Customer.class);

        Mono<Customer> updateCustomer = customerMono.flatMap(customer -> {
            Mono<Customer> byId = repository.findById(id);
            return byId.flatMap(customer1 -> {
                customer.setCustomerId(id);
                return repository.save(customer);
            });
        });

        return updateCustomer.flatMap(customer -> ServerResponse.ok().body(BodyInserters.fromValue(customer)))
                .switchIfEmpty(ServerResponse.notFound().build());


     /*return  repository.findById(id).flatMap(customer -> customerMono.doOnNext(customer1 -> customer1.setCustomerId(id))
             .flatMap(repository::save).flatMap(customer1 -> ServerResponse.ok().body(customer1, Customer.class)))
                .switchIfEmpty(Mono.error(new RecordNotFoundException("Record Not Found")))
                .onErrorResume(error -> {
                    if (error instanceof RecordNotFoundException) {
                        return ServerResponse.notFound().build();
                    } else {
                        System.out.println(""+error.getMessage());
                        return ServerResponse.status(200).build();
                    }
                });*/



       /* repository.findById(id).map(customer -> customer)
                .switchIfEmpty(Mono.error(new RecordNotFoundException("Record Not Found")));

        Mono<Customer> saveResponse = customerMono.map(customer -> {
            customer.setCustomerId(id);
            return customer;
        }).flatMap(customer -> repository.save(customer));

        return customerMono.flatMap(customer -> ServerResponse.ok().body(saveResponse, Customer.class))
                .onErrorResume(error -> {
                    if (error instanceof RecordNotFoundException) {
                        return ServerResponse.notFound().build();
                    } else {
                        return ServerResponse.status(500).build();
                    }
                });*/

        /*Mono<Customer> customerMono = repository.findById(id)
                .map((c) -> {
                    c.setName(customer.getName());
                    return c;
                }).flatMap(c -> repository.save(c));*/

        //  return ServerResponse.ok().body(saveResponse, Customer.class).onErrorResume(error -> ServerResponse.badRequest().build());

    }


    public Mono<ServerResponse> deleteCustomer(ServerRequest request) {
        long id = Long.parseLong(request.pathVariable("id"));
        Mono<Void> customerMono = repository.deleteById(id);
        return ServerResponse.ok().body(customerMono, Customer.class);
    }


    // https://github.com/kjoshi07/webflux-crud-demo/blob/master/src/main/java/com/kj/webfluxcruddemo/handler/EmployeeHandler.java
   /* public Mono<ServerResponse> updateEmployee(ServerRequest request) {
        String employeeId = request.pathVariable("id");
        Mono<Employee> employeeMono = request.bodyToMono(Employee.class);
        return employeeRepository.findById(employeeId)
                .flatMap(employee -> employeeMono.flatMap(employee1 -> {
                    employee.setFirstName(employee1.getFirstName());
                    employee.setLastName(employee1.getLastName());
                    Mono<Employee> updatedEmployee = employeeRepository.save(employee);
                    return ServerResponse.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(updatedEmployee, Employee.class);
                }));
    }*/

}
