package com.hyj.demo.entity;

/**
 * 线程类
 */
public class Process implements Runnable{
    @Override
    public void run() {
        try{
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+"-->休息结束");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
