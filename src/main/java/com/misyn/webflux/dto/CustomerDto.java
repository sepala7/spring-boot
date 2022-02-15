package com.misyn.webflux.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private Long customerId;
    private String name;
    private String nic;
    private Integer customerType;
}
