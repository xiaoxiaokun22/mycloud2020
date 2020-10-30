package com.atguigu.springcloud.service;

import com.atguigu.springcloud.controller.Response;

public interface PaymentService {

    Response getPaymentOk(Integer id);

    Response getPaymentTimeout(Integer id);

    Response getDetail(Integer id);
}
