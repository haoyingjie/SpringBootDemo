package com.hyj.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hyjTest02")
public class Receiver2 {
    @RabbitHandler
    public void receiver(String msg){
        System.out.println("hyjTest02 receiver2:"+msg);
    }
}
