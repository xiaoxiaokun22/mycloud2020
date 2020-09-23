package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.BaseService;
import com.atguigu.springcloud.service.Request;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    @Autowired
    @Qualifier("CloudRequest")
    Request args;
}
