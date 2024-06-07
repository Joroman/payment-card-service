package com.accidpayments.microservices.paymentcardservice.controller;

import com.accidpayments.microservices.paymentcardservice.bean.Payment;
import com.accidpayments.microservices.paymentcardservice.configuration.Configuration;
import com.accidpayments.microservices.paymentcardservice.proxy.StripeProviderProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class PaymentController {
    @Autowired
    private Configuration configuration;
    @Autowired
    private StripeProviderProxy stripeProviderProxy;
    @GetMapping("/payment/card")
    public Payment getPayment (){
        double amount= 80000.00;

        if(configuration.getMin_amount() < amount && amount < configuration.getMax_amount()){
            return new Payment("buy piano", amount,"EUR", "DONE","CARD","NONE",new Date(),new Date());
        }

        return new Payment("buy piano", 100.25,"EUR", "DONE","CARD","NONE", new Date(),new Date());
    }

    @GetMapping("/payment/configuration")
    public Configuration getLimitsAmount(){
        return configuration;
    }

    @GetMapping("/payment/card/{id}")
    public Payment getPaymentId(@PathVariable int id){
        Payment stripePayement = stripeProviderProxy.getPaymentById(id);
        return new Payment(stripePayement.getDescription(),stripePayement.getAmount(),stripePayement.getCurrency(),
                "DONE","CARD", "STRIPE", new Date(), new Date());
    }

    @PostMapping("/payment/card")
    public Payment makePayment(@RequestBody Payment request){

        return stripeProviderProxy.makePayment(request);
    }

}
