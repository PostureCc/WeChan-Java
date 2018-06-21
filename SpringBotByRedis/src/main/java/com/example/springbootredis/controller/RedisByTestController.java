package com.example.springbootredis.controller;

import com.example.springbootredis.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class RedisByTestController {
    @Autowired
    private RedisService redisService ;

    @RequestMapping(value = "/")
    public String holle(){
        return "index";
    }

    @RequestMapping(value = "/springBootByTest")
    public String springBootByTest(){
        return "Hello SpringBoot";
    }

    @RequestMapping(value = "/redisBypush")
    public void redisBypush(String key,String var){
        redisService.set(key,var);
    }

    @RequestMapping(value = "/redisByGet")
    public String redisByGet(String key){
        return redisService.get(key).toString();
    }

}
