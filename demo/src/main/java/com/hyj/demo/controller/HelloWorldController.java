package com.hyj.demo.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloWorldController{

    @Value("${rabbitmq}")
    private String rabbitmq;
    @RequestMapping("/helloWorld")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String showInfo = request.getParameter("showInfo");
        String url = request.getRequestURI();
        System.out.println("GET 请求参数showInfo："+ showInfo);
        System.out.println("url:"+url);
        System.out.println("rabbitmq的地址："+rabbitmq);
        JSONObject json = new JSONObject();
        json.put("code",200);
        json.put("messag","成功");
        json.put("data",showInfo);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json.toString());
//        return showInfo;
//        return "helloworld  Springboot!";
    }

}
