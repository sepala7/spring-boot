package com.misyn.webflux.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class OrderCustomer {
    @Id
    private Long orderCustomerId;
    @Column
    private Long orderId;
    @Column
    private Long customerId;
    @Column
    private Date orderDate;
}
