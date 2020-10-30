package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "globalHandler")
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/get/ok/{id}")
    Response getPaymentOk(@PathVariable("id")Integer id){
        return paymentService.getPaymentOk(id);
    }

    @GetMapping("/consumer/payment/get/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
//    @HystrixCommand
    Response getPaymentTimeout(@PathVariable("id")Integer id){
        return paymentService.getPaymentTimeout(id);
    }

    public Response paymentHandler(Integer id){
        Map<String,Object> res = new HashMap<>();
        res.put("类型","消费端降级");
        res.put("线程池",Thread.currentThread().getName());
        return Response.ok(res);
    }

    public Response globalHandler(){
        return Response.ng("服务异常，请稍后访问");
    }
}
