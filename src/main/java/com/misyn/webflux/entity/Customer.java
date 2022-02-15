package com.misyn.webflux.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private Long customerId;
    @Column
    private String name;

    
    @Column
    private String nic;

    @Column
    private Integer customerType;
}
