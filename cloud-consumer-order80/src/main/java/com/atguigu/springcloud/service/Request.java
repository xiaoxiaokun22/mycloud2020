package com.atguigu.springcloud.service;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.*;

@Service("CloudRequest")
public class Request {

    @Autowired
    public HttpServletRequest request;

    public Request() {
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //this.request = request;
    }

    public Map<String, Object> s() {
        Map<String, Object> maps = new HashMap<>();
        if (request == null && request.getSession() == null) {
            return maps;
        }
        Enumeration<String> enumeration = request.getSession().getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String k = enumeration.nextElement();
            Object v = s(k);
            maps.put(k, v);
        };
        return maps;
    }

    public Object s(String name) {
        if (request == null && request.getSession() == null) {
            return null;
        }
        return request.getSession().getAttribute(name);
    }

    public Integer uid() {
        Integer uid = (int) s("uid");
        if (uid == null) {
            uid = 0;
        }
        return uid;
    }

    public Integer agentUid() {
//        Integer agentUid = 0;
//        Integer uid = this.uid();
//        User user = userService.getById(uid);
//        if (user.getType().equals(KolEnum.UserTypeEnum.AGENT.getValue())) {
//            agentUid = uid;
//        }
//        if (user.getType().equals(KolEnum.UserTypeEnum.AGENT_USER.getValue())
//                || user.getType().equals(KolEnum.UserTypeEnum.AGENT_OP.getValue())) {
//            agentUid = user.getPid();
//        }
//        return agentUid;
        return null;
    }

    public List<Integer> groupUids() {
//        Integer uid = this.uid();
//        List<Integer> uids = new ArrayList<>();
//        uids.add(uid);
//        Integer pid = Integer.parseInt(String.valueOf(s("pid")));
//        if (pid > 0) {
//            uids.add(pid);
//            List<Map<String, Object>> users = userService.listMaps(new QueryWrapper<User>().eq("pid", pid));
//            userServiceImpl.arrayColumn(users, "id").forEach(i -> uids.add(Integer.parseInt(i)));
//        }
//        return uids.stream().distinct().collect(Collectors.toList());
        return null;
    }

    public String username() {
        String username = (String) s("name");
        if (username == null) {
            username = "";
        }
        return username;
    }

    public void s(String name, Object object) {
        if (request == null && request.getSession() == null) {
            return ;
        }
        request.getSession().setAttribute(name, object);
    }

    public Object i(String name) {
        return request.getParameter(name);
    }

    public Object[] ia(String name) {
        Object[] objs = request.getParameterValues(name);
        if (objs == null) {
            objs = new Object[0];
        }
        return objs;
    }

    public String[] ias(String name) {
        return request.getParameterValues(name);
    }

    public Object i(String name, Object nullMaker) {
        Object val = i(name);
        return val == null ? nullMaker : val;
    }

    public void set(String name, Object obj) {
        request.setAttribute(name, obj);
    }

    public boolean ib(String name) {
        boolean nullMaker = false;
        return ib(name, nullMaker);
    }

    public boolean ib(String name, boolean nullMaker) {
        String val = (String) i(name, String.valueOf(nullMaker));
        if (val.equals("true")) {
            return true;
        }
        return false;
    }

    public int ii(String name) {
        int nullMaker = 0;
        return ii(name, nullMaker);
    }

    public BigDecimal ibig(String name) {
        return ibig(name, BigDecimal.ZERO);
    }

    public BigDecimal ibig(String name, BigDecimal nullmaker) {
        if (StrUtil.isEmpty(is(name))) {
            return nullmaker;
        }
        return new BigDecimal(is(name));
    }


    public int ii(String name, int nullMaker) {
        String val = (String) i(name, String.valueOf(nullMaker));
        return Integer.parseInt(val);
    }

    public long iL(String name) {
        long nullMaker = 0L;
        return iL(name, nullMaker);
    }

    public long iL(String name, long nullMaker) {
        String val = (String) i(name, String.valueOf(nullMaker));
        return Long.parseLong(val);
    }

    public String is(String name, String nullMaker) {
        String val = (String) i(name, nullMaker);
        return val;
    }

    public String is(String name) {
        String val = (String) i(name, "");
        return val == null ? "" : val;
    }

    public HashMap<String, Object> i() {
        Enumeration names = request.getParameterNames();
        HashMap<String, Object> attrs = new HashMap<>();
        while (names.hasMoreElements()) {
            String attr = (String) names.nextElement();
            Object val = request.getParameter(attr);
            attrs.put(attr, val);
        }
        return attrs;
    }
    public String getQueryString(){
        String val = "";
        if(request.getQueryString() != null){
            try {
                val = URLDecoder.decode(request.getQueryString(),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return val;
    }
}
