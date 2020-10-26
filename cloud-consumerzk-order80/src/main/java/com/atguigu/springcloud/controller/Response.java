package com.atguigu.springcloud.controller;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Response implements Serializable {
    private static final long serialVersionUID = 183749910L;

    private int code = 200;
    private String status = "success";
    static String statusOk = "success";
    static String statusNg = "failure";
    private String msg = "";
    private Object data = new ArrayList<>();

    public Response setCode() {
        return this.setCode(200);
    }

    public Response setCode(int code) {
        this.code = code;
        return this;
    }

    public static Response ok() {
        Response res = new Response();
        res.setCode(200);
        res.setStatus(statusOk);
        return res;
    }

    public static Response ok(String msg) {
        Response res = ok();
        res.setMsg(msg);
        return res;
    }

    public static Response ok(Object data) {
        Response res = ok();
        res.setData(data);
        return res;
    }

    public static Response ok(String msg, Object data) {
        Response res = ok(data);
        res.setMsg(msg);
        return res;
    }

    public static Response ok(Object data, String msg) {
        return ok(msg, data);
    }

    public static Response ng() {
        Response res = new Response();
        res.setCode(200);
        res.setStatus(statusNg);
        return res;
    }

    public static Response ng(String msg) {
        Response res = ng();
        res.setMsg(msg);
        return res;
    }

    public static Response ng(Object data) {
        Response res = ng();
        res.setData(data);
        return res;
    }

    public static Response ng(String msg, Object data) {
        Response res = ng(data);
        res.setMsg(msg);
        return res;
    }

    public static Response ng(Object data, String msg) {
        return ng(msg, data);
    }

}

