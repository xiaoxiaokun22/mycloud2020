package com.atguigu.springcloud.service;

import com.atguigu.springcloud.controller.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentService {

    @GetMapping("/payment/get/ok/{id}")
    Response getPaymentOk(@PathVariable("id")Integer id);

    @GetMapping("/payment/get/timeout/{id}")
    Response getPaymentTimeout(@PathVariable("id")Integer id);
}
