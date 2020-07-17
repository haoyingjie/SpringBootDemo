package com.hyj.demo.mapper;
import com.hyj.demo.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    UserEntity Sel(int id);
    List<Map<String, Object>> findAll();
    void save(Map<String, Object> param);
}
