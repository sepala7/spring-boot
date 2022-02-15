package com.misyn.webflux.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderCustomerDto {
    private Long orderCustomerId;
    private CustomerDto customerDto=new CustomerDto();
    private OrderDto orderDto=new OrderDto();
    private LocalDateTime orderDateTime;
}
