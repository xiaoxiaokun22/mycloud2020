package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class PaymentController extends BaseController{

   @Autowired
   private PaymentService paymentService;

   @PostMapping("/payment/create")
   public Response create(){
       Response res = paymentService.addPayment();
       return  res;
   }
   @GetMapping("/payment/get/{id}")
   public Response getPaymentById(@PathVariable("id")Long id){
       Map<String,Object> res = paymentService.getInfo(id);
       return  Response.ok(res);
   }
}
