package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.controller.Response;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Response getPaymentOk(Integer id){

        Map<String,Object> res = new HashMap<>();
        res.put("类型" ,"ok");
        res.put("线程池",Thread.currentThread().getName());
        res.put("id",id);
        return  Response.ok(res);
    }

    @Override
    public Response getPaymentTimeout(Integer id) {
        int timeSecond = 3;
        try {
            TimeUnit.SECONDS.sleep(timeSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String,Object> res = new HashMap<>();
        res.put("类型" ,"timeout");
        res.put("线程池",Thread.currentThread().getName());
        res.put("id",id);
        res.put("耗时",timeSecond);
        return  Response.ok(res);
    }
}
