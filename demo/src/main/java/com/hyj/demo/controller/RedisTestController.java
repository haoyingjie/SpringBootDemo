package com.hyj.demo.controller;

import com.hyj.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisTest")
public class RedisTestController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/setRedis")
    public String setRedis(){
        ValueOperations<String, String> valueOperationsStrRedis = stringRedisTemplate.opsForValue();
        ValueOperations<String, Object> valueOperationsRedis = redisTemplate.opsForValue();
        valueOperationsStrRedis.set("info","你好redis！");
        UserEntity user = new UserEntity(3L,"hyj","123456");
        valueOperationsRedis.set("user",user);
        return "setRedis sucess!";
    }
    @RequestMapping("/getRedis")
    public String getRedis(){
        ValueOperations<String,String> valueOperationsStrRedis=stringRedisTemplate.opsForValue();
        ValueOperations<String,Object> valueOperationsRedis=redisTemplate.opsForValue();
        String info=valueOperationsStrRedis.get("info");
        UserEntity user=(UserEntity) valueOperationsRedis.get("user");
        return info+user.toString();
    }
}
