package com.misyn.webflux.router;

import com.misyn.webflux.handler.CustomerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler customerHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .POST("/router/customers", customerHandler::createCustomer)
                .PUT("/router/customers/{id}", customerHandler::updateCustomer)
                .DELETE("/router/customers/{id}", customerHandler::deleteCustomer)
                .GET("/router/customers", customerHandler::getCustomers)
                .GET("/router/customers/{id}", customerHandler::getCustomer)
                .build();
    }
}
