package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class PaymentController extends BaseController{

   @Autowired
   private PaymentService paymentService;
   @Autowired
   private DiscoveryClient discoveryClient;

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

   @GetMapping("/payment/discovery")
   public Object discovery(){
       Log.info("=====所有服务=====");
       List<String> services = discoveryClient.getServices();
       for(String str:services){
           Log.info("===:"+str);
       }

       Log.info("=====CLOUD-PAYMENT-SERVICE微服务下的实例=====");
       List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
       for(ServiceInstance serviceInstance:serviceInstances){
           Log.info(serviceInstance.getUri().toString());
       }
       return discoveryClient;
   }
}
