package com.ify.services.orderservice.controller;

import com.ify.services.orderservice.common.TransactionRequest;
import com.ify.services.orderservice.common.TransactionResponse;
import com.ify.services.orderservice.entity.Order;
import com.ify.services.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/bookorder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest order){
        return service.saveOrder(order);
    }
}
