package com.ify.services.orderservice.common;

import com.ify.services.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class TransactionResponse {
    private Order order;
    private double amount;
    private String transactionStatus;
    private String message;
}
