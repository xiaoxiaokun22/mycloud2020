package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.controller.Response;
import com.atguigu.springcloud.dao.PaymentMapper;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class PaymentServiceImpl extends BaseServiceImpl<PaymentMapper, Payment> implements PaymentService {


    @Override
    public Map<String, Object> getInfo(Long id) {
        return null;
    }

    @Override
    public Response addPayment() {

        return Response.ok();
    }
}
