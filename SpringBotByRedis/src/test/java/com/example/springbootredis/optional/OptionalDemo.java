package com.example.springbootredis.optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] agrs) {
        whenCreateEmptyOptional_thenNull();
    }

    static void whenCreateEmptyOptional_thenNull() {

        User user = new User();
//        user.setId(1);
//        user.setName("name");
//        Optional<User> emptyOpt = Optional.empty();
        Optional<User> opt = Optional.of(user);
        System.out.println("使用Optional获取null值:" + opt.get().getName());
        System.out.println("不使用Optional获取null值:" + user.getName());
    }

}
