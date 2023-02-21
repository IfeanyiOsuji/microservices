package com.ify.payments.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "payment_TB")
public class Payment {
    @Id
    @GeneratedValue
    private int paymentId;
    private String paymentStatus;
    @GeneratedValue
    private String transactionStId;
    private int orderid;
    private double amount;

}
