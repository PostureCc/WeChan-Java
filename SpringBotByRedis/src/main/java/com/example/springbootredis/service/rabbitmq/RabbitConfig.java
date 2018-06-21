package com.example.springbootredis.service.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 队列配置
 * RabbitMq配置中心,由SpringBoot提供的相关包自动整合
 */
@Configuration
public class RabbitConfig {

    /**
     * 声明变量作为动态消息
     */
    public static String msg;

    /**
     * 声明队列
     */
    @Bean
    public Queue queue1() {
        //durable:true表示持久化该队列
        return new Queue("hello.queue1", true);
    }

    @Bean
    public Queue queue2() {
        return new Queue(msg, true);
    }

    /**
     * 声明交互器
     */
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 绑定
     */
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("key.1");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("key.#");
    }
}
