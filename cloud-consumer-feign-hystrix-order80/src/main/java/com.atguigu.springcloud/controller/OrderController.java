package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/get/ok/{id}")
    Response getPaymentOk(@PathVariable("id")Integer id){
        return paymentService.getPaymentOk(id);
    }

    @GetMapping("/consumer/payment/get/timeout/{id}")
    Response getPaymentTimeout(@PathVariable("id")Integer id){
        return paymentService.getPaymentTimeout(id);
    }

}
