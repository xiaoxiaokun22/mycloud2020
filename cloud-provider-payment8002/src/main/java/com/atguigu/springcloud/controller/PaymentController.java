package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController extends BaseController{

    @Value("${server.port}")
    private String serverPort;

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
    @GetMapping("/payment/feign/timeout")
    public Response timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Response.ok(serverPort);
    }
}
