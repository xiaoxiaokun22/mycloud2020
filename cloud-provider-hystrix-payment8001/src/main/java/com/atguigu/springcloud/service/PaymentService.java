package com.atguigu.springcloud.service;

import com.atguigu.springcloud.controller.Response;
import org.springframework.stereotype.Service;

public interface PaymentService {

    Response getPaymentOk(Integer id);

    Response getPaymentTimeout(Integer id);
}
