package com.accidpayments.microservices.paymentcardservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class PaymentCardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentCardServiceApplication.class, args);
	}

}
