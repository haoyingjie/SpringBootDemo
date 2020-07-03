package com.hyj.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloWorldController{

    @Value("${rabbitmq}")
    private String rabbitmq;
    @RequestMapping("/helloWorld")
    public String helloWorld(HttpServletRequest request) throws Exception{
        String showInfo = request.getParameter("showInfo");
        String url = request.getRequestURI();
        System.out.println("GET 请求参数showInfo："+ showInfo);
        System.out.println("url:"+url);
        System.out.println("rabbitmq的地址："+rabbitmq);
        return showInfo;
//        return "helloworld  Springboot!";
    }

}
