package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/get/ok/{id}")
    public Response getPaymentOk(@PathVariable("id")Integer id){

        return paymentService.getPaymentOk(id);
    }

    @GetMapping("/payment/get/timeout/{id}")
    public Response getPaymentTimeout(@PathVariable("id")Integer id){

        return paymentService.getPaymentTimeout(id);
    }

    @GetMapping("/payment/get/detail/{id}")
    public Response getDetail(@PathVariable("id")Integer id){

        return paymentService.getDetail(id);
    }
}
