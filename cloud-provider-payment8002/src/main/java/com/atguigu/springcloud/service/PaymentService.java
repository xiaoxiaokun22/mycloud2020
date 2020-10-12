package com.atguigu.springcloud.service;

import com.atguigu.springcloud.controller.Response;
import com.atguigu.springcloud.entities.Payment;

import java.util.Map;

public interface PaymentService extends BaseService<Payment>{
    Map<String, Object> getInfo(Long id);

    Response addPayment();
}
