package com.atguigu.springcloud.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.atguigu.springcloud.entities.Payment;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class OrderController extends BaseController{

    public static final String PAYMENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/create")
    public Response create(){
        String queryString = StrUtil.isEmpty(args.getQueryString()) ? "" : "?" + args.getQueryString();
        Log.info("===queryString===");
        Log.info(queryString);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create" + queryString,null,Response.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public Response getInfo(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/"+id,Response.class);
    }
}
