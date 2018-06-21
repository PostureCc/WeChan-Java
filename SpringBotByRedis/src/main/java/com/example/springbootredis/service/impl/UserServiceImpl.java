package com.example.springbootredis.service.impl;

import com.example.springbootredis.dao.UserDao;
import com.example.springbootredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<Map<String, Object>> getInfo() {
        return userDao.getInfo();
    }
}
