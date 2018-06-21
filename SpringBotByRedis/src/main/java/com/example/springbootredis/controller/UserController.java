package com.example.springbootredis.controller;

import com.example.springbootredis.service.UserService;
import com.example.springbootredis.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getInfo")
    public Object getInfo() {
        return userService.getInfo();
    }

    @RequestMapping(value = "/redisByUserPush")
    public void redisByPush(String key) {
        for (Map use : userService.getInfo()) {
            if ("1".equals(use.get("ID") + "")) {
                System.out.println("进来了:" + use.get("ID"));
                Map<String, Object> map = new HashMap<>(5);
                map.put("id", use.get("id"));
                map.put("user_name", use.get("userName"));
                redisService.set(key, map);
            }
        }
    }

    @RequestMapping(value = "/redisByUserGet")
    public Object redisByGet(String key) {
        return redisService.get(key);
    }
}
