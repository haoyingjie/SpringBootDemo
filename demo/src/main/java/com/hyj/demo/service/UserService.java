package com.hyj.demo.service;

import com.hyj.demo.entity.UserEntity;
import com.hyj.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public UserEntity Sel(int id){
        return userMapper.Sel(id);
    }

    public List<Map<String, Object>> findAll(){
        return userMapper.findAll();
    }

    public void save(Map<String, Object> param){
        userMapper.save(param);
    }
}
