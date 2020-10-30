package com.atguigu.springcloud.service;

import com.atguigu.springcloud.controller.Response;
import com.atguigu.springcloud.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("/payment/get/ok/{id}")
    Response getPaymentOk(@PathVariable("id")Integer id);

    @GetMapping("/payment/get/timeout/{id}")
    Response getPaymentTimeout(@PathVariable("id")Integer id);
}
