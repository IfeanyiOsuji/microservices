package com.ify.services.orderservice.service;

import com.ify.services.orderservice.common.Payment;
import com.ify.services.orderservice.common.TransactionRequest;
import com.ify.services.orderservice.common.TransactionResponse;
import com.ify.services.orderservice.entity.Order;
import com.ify.services.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request){
        StringBuilder builder = new StringBuilder();
        Order order = new Order();
        order.setName(request.getOrderdto().getName());
        order.setQuantity(request.getOrderdto().getQuantity());
        order.setPrice(request.getOrderdto().getPrice());

        Payment payment = request.getPayment();

        payment.setAmount(order.getPrice());
         Order savedOrder = repository.save(order);
         payment.setOrderid(savedOrder.getId());
        Payment paymentResponse = restTemplate.postForObject("http://localhost:9193/payment/makepayment", payment, Payment.class);
        assert paymentResponse != null;
        builder = paymentResponse.getPaymentStatus().equals("success")? builder.append("payment processing successful and ordewrplaced"): builder.append("payment processing failed");

        return TransactionResponse.of(order, paymentResponse.getAmount(), paymentResponse.getPaymentStatus(), builder.toString());

    }


}
