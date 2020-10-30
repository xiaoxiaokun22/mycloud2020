package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.controller.Response;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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

    /**
     * fallbackMethod方法的参数要与getPaymentTimeout方法相同
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
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
    public Response timeoutHandler(Integer id){
        Map<String,Object> res = new HashMap<>();
        res.put("类型" ,"访问过多");
        res.put("线程池",Thread.currentThread().getName());
        return Response.ok(res);
    }

    /**
     * 熔断阀值：12秒内请求10次，有超过百分之60的错误请求，则就熔断。
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "detailHandler",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "12000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public Response getDetail(Integer id){
        if(id < 0){
            throw new RuntimeException("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        Map<String,Object> res = new HashMap<>();
        res.put("状态","正常");
        res.put("流水号",uuid);
        return Response.ok(res);
    }

    public Response detailHandler(Integer id){
        return Response.ok("请求异常，请稍后再试");
    }

}
