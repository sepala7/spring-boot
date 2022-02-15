package com.misyn.webflux.repository.impl;

import com.misyn.webflux.dto.OrderCustomerDto;
import com.misyn.webflux.mapper.CustomerMapper;
import com.misyn.webflux.repository.CustomCustomerRepository;
import org.springframework.data.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

public class CustomCustomerRepositoryImpl implements CustomCustomerRepository {

    private DatabaseClient client;

    public CustomCustomerRepositoryImpl(DatabaseClient client) {
        this.client = client;
    }

    @Override
    public Flux<OrderCustomerDto> findAllCustomer(Long orderId) {
        CustomerMapper mapper = new CustomerMapper();
        String sql = "SELECT\n" +
                "	c.`customer_id`, \n" +
                "	c.`name`, \n" +
                "	c.`nic`, \n" +
                "	c.`customer_type`, \n" +
                "	o.order_name, \n" +
                "	oc.order_customer_id, \n" +
                "	oc.order_id, \n" +
                "	oc.order_date\n" +
                "FROM\n" +
                "	order_customer AS oc\n" +
                "	INNER JOIN\n" +
                "	customer AS c\n" +
                "	ON \n" +
                "		oc.customer_id = c.customer_id\n" +
                "	INNER JOIN\n" +
                "	`order` AS o\n" +
                "	ON \n" +
                "		oc.order_id = o.order_id\n" +
                "WHERE\n" +
                "	oc.order_id = :order_id";

        Flux<OrderCustomerDto> result = client.execute(sql)
                .bind("order_id", orderId)
                .map(mapper::apply).all();

        return result;
    }
}
