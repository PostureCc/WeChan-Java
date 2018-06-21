package com.example.springbootredis.service.rabbitmq;

import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 生产者
 *
 * 实现RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback接口（非必须）。
 * ConfirmCallback接口用于实现消息发送到RabbitMQ交换器后接收ack回调。
 * ReturnCallback接口用于实现消息发送到RabbitMQ交换器，但无相应队列与交换器绑定时的回调。
 */
@Component
public class Sender implements RabbitTemplate.ConfirmCallback, ReturnCallback {

    /**
     * rabbitTemplate是springboot 提供的默认实现
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("消息发送成功:" + correlationData);
        } else {
            System.out.println("消息发送失败:" + cause);
        }

    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println(message.getMessageProperties().getCorrelationIdString() + " 发送失败");

    }

    /**
     * 发送消息，不需要实现任何接口，供外部调用。
     * <p>
     * 实现消息发送方法。调用rabbitTemplate相应的方法即可。rabbitTemplate常用发送方法有
     * rabbitTemplate.send(message);  //发消息，参数类型为org.springframework.amqp.core.Message
     * rabbitTemplate.convertAndSend(object); //转换并发送消息。 将参数对象转换为org.springframework.amqp.core.Message后发送
     * rabbitTemplate.convertSendAndReceive(message) //转换并发送消息,且等待消息者返回响应消息。
     */
    public void send(String msg) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("开始发送消息 : " + msg.toLowerCase());
        String response = rabbitTemplate.convertSendAndReceive("topicExchange", "key.1", msg, correlationId).toString();
        System.out.println("结束发送消息 : " + msg.toLowerCase());
        System.out.println("消费者响应 : " + response + " 消息处理完成");
    }
}
