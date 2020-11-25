package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope
 * git的yml配置修改后，需要运维手动刷新config客户端，
 * curl -X POST "http://localhost:3355/actuator/refresh"
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/getInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
