package com.hyj.demo.controller;


import com.hyj.demo.entity.Process;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Async")
public class AsyncTestController {

    @RequestMapping("/Test")
    public String TestStopWatch(HttpServletRequest request) throws Exception{
        System.out.println("开始进行异步测试：");
        StopWatch stopWatch = new StopWatch("任务计时");
        System.out.println("任务1：");
        long startTime = System.currentTimeMillis();
        System.out.println("当前时间："+startTime);
        stopWatch.start("任务1:");
//        Process process1 = new Process();
//        Thread thread = new Thread(process1);
//        thread.setName("线程Process1");
//        System.out.println("开始执行新线程：");
//        thread.start();
        Thread.sleep(1000);
        stopWatch.stop();
        long endTime = System.currentTimeMillis();
        System.out.println("当前时间："+endTime);
        stopWatch.start("任务2：");
        Thread.sleep(2000);
        stopWatch.stop();
        String result = stopWatch.prettyPrint();
        System.out.println("loading.....");
        System.out.println(result);
        System.out.println("提交测试？");
        return "异步测试！";
    }
}
