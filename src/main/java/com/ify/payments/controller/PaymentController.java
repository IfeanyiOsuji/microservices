package com.ify.payments.controller;


import com.ify.payments.entity.Payment;
import com.ify.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService service;
   @PostMapping("/makepayment")
    public Payment makePayment(@RequestBody Payment payment){
        return service.savePayment(payment);
    }
}
