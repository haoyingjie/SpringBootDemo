package com.hyj.demo.controller;

import com.hyj.demo.entity.UserEntity;
import com.hyj.demo.mapper.UserMapper;
import com.hyj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUser/{id}")
    public String getUser(@PathVariable int id) throws  Exception{
        return userService.Sel(id).toString();
    }
    @RequestMapping("/findAll")
    public String findAll() throws Exception{
        return userService.findAll().toString();
    }

    @RequestMapping("/save")
    public String save(HttpServletRequest request) throws Exception{
        Map<String, Object> para = new HashMap<>();
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String realName = request.getParameter("realName");
        para.put("userName",userName);
        para.put("passWord",passWord);
        para.put("realName",realName);
        userService.save(para);
        return "保存信息成功:"+para.toString();
    }
}
