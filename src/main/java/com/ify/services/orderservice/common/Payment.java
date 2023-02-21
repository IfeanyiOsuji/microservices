package com.ify.services.orderservice.common;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {

    private int paymentId;
    private String paymentStatus;
    private String transactionStId;
    private int orderid;
    private double amount;

}
