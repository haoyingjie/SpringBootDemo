package com.hyj.demo.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/mqSendTest")
public class SendController {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @RequestMapping("/send")
    public String send(){
        String content = "日期:"+ new Date();
        amqpTemplate.convertAndSend("hyjTest01",content);
        System.out.println("发送消息："+content);
        return content;
    }
    @RequestMapping("/multiSend")
    public String multiSend(){
        StringBuilder times = new StringBuilder();
        int num = 10;
        for(int i=0; i<num; i++){
            long time = System.nanoTime();
            amqpTemplate.convertAndSend("hyjTest01","第"+i+"条消息,时间："+time);
            times.append("第"+i+"条消息,时间："+time+"<br>");
        }
        return times.toString();
    }
    @RequestMapping("/multi2MultiSend")
    public String multi2MultiSend(){
        StringBuilder times = new StringBuilder();
        int num = 10;
        for(int i=0; i<num; i++){
            long time = System.nanoTime();
            amqpTemplate.convertAndSend("hyjTest01","第"+i+"条消息,时间："+time);
            amqpTemplate.convertAndSend("hyjTest02","第"+i+"条消息,时间："+time);
            times.append("第"+i+"条消息,时间："+time+"<br>");
        }
        return times.toString();
    }
    @RequestMapping("/topicSend1")
    public String topicSend1(){
        String context = "my topic 1";
        System.out.println("发送者说："+context);
        this.amqpTemplate.convertAndSend("exchange","topic.message",context);
        return context;
    }
    @RequestMapping("/topicSend2")
    public String topicSend2(){
        String context = "my topic 2";
        System.out.println("发送者说："+context);
        this.amqpTemplate.convertAndSend("exchange","topic.messages",context);
        return context;
    }
}
