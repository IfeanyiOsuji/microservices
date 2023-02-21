package com.ify.payments.service;


import com.ify.payments.entity.Payment;
import com.ify.payments.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository repository;

    public Payment savePayment(Payment payment){

        payment.setTransactionStId(UUID.randomUUID().toString());
        payment.setPaymentStatus(paymentProcessing());
        return repository.save(payment);

    }

    public String paymentProcessing(){
        // Api should make call to third party payment gateway e.g paypal, interswitch
        return new Random().nextBoolean()? "success":"false";
    }
}
