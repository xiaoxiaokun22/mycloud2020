package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.controller.Response;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Response getPaymentOk(Integer id) {
        return Response.ok("服务端崩溃，ok");
    }

    @Override
    public Response getPaymentTimeout(Integer id) {
        return Response.ok("服务端崩溃，timeout");
    }
}
