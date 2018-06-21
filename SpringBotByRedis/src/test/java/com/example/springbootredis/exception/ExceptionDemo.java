package com.example.springbootredis.exception;

import org.springframework.util.StringUtils;

import java.util.NoSuchElementException;

public class ExceptionDemo {
    public static void main(String[] agrs){
        throwsDemo();
    }

    static void throwsDemo() {
        String str = null;
        if(StringUtils.isEmpty(str)){
            throw new NoSuchElementException("No value");
        }
    }
}
