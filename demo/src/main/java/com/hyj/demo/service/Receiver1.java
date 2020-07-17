package com.hyj.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hyjTest01")
public class Receiver1 {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println("hyjTest01 receiver1:"+msg);
    }
}
