package com.example.springbootredis.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao /*extends JpaRepository<Map<String,Object>, Long>*/ {

    @Select("SELECT * FROM T_USER_INFO LIMIT 10")
    /*@Results:给列名起别名*/
    @Results({@Result(property = "id", column = "ID"), @Result(property = "userName", column = "USER_NAME")})
    List<Map<String, Object>> getInfo();
}
