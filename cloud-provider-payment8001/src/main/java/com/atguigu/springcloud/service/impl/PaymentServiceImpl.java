package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.StrUtil;
import com.atguigu.springcloud.controller.Response;
import com.atguigu.springcloud.dao.PaymentMapper;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServiceImpl extends BaseServiceImpl<PaymentMapper, Payment> implements PaymentService {


    @Override
    public Map<String, Object> getInfo(Long id) {
        Payment payment = getOne(new QueryWrapper<Payment>()
                .eq("id",id));
        if(payment == null){
            return new HashMap<>();
        }
        Map<String,Object> res = new HashMap<>();
        res.put("id",payment.getId());
        res.put("serial",payment.getSerial());
        return res;
    }

    @Override
    public Response addPayment() {
        String id = args.is("id");
        String serial = args.is("serial");
        String msg = "新增";
        Payment payment = new Payment();
        if(StrUtil.isNotEmpty(id)){
            msg = "更新";
            payment = getById(id);
        }
        if(payment == null){
            return Response.ok("信息不存在");
        }
        payment.setSerial(serial);
        if(saveOrUpdate(payment)){
            return Response.ok(msg + "成功");
        }
        return Response.ok(msg + "失败");
    }
}
