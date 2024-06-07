package com.accidpayments.microservices.paymentcardservice.proxy;

import com.accidpayments.microservices.paymentcardservice.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name="stripe-provider-service", url="localhost:8000")
//with load balancing write new line with just the name because FEIGN client talk to EUREKA NAMING SERVER
@FeignClient(name="stripe-provider-service")
public interface StripeProviderProxy {

    @GetMapping("/payment/stripe/{id}")
    public Payment getPaymentById(@PathVariable int id);

    @PostMapping("/payment/stripe")
    public Payment makePayment(@RequestBody Payment request);
}
