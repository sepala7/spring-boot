package com.misyn.webflux.mapper;

import com.misyn.webflux.dto.OrderCustomerDto;
import io.r2dbc.spi.Row;

import java.time.LocalDateTime;
import java.util.function.BiFunction;

public class CustomerMapper implements BiFunction<Row, Object, OrderCustomerDto> {
    @Override
    public OrderCustomerDto apply(Row row, Object o) {
        OrderCustomerDto orderCustomerDto = new OrderCustomerDto();
        orderCustomerDto.setOrderCustomerId(row.get("order_customer_id", Long.class));
        orderCustomerDto.getOrderDto().setOrderId(row.get("order_id", Long.class));
        orderCustomerDto.getOrderDto().setOrderName(row.get("order_name", String.class));
        orderCustomerDto.getCustomerDto().setCustomerId(row.get("customer_id", Long.class));
        orderCustomerDto.getCustomerDto().setName(row.get("name", String.class));
        orderCustomerDto.getCustomerDto().setNic(row.get("nic", String.class));
        orderCustomerDto.getCustomerDto().setCustomerType(row.get("customer_type", Integer.class));
        orderCustomerDto.setOrderDateTime(row.get("order_date", LocalDateTime.class));
        return orderCustomerDto;
    }
}
