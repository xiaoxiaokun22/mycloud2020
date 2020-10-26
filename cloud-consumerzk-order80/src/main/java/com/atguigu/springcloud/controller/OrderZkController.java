package com.atguigu.springcloud.controller;

import cn.hutool.core.util.StrUtil;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZkController {
    public static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public Response getInfo(@PathVariable("id") Long id){
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk",Response.class);
    }
}
