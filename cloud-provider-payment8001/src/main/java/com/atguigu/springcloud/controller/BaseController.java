package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseController {
    @Autowired
    @Qualifier("CloudRequest")
    protected Request args;
}
