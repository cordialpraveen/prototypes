package com.wedaa.notes.notification.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigActionToNotification {

    public static final String QUEUE = "ActionToNotification_message_queue";
    public static final String EXCHANGE = "ActionToNotification_message_exchange";
    public static final String ROUTING_KEY = "ActionToNotification_message_routingKey";

    @Bean
    public Queue queueActionToNotification() {
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchangeActionToNotification() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingActionToNotification() {
        return BindingBuilder.bind(this.queueActionToNotification()).to(this.exchangeActionToNotification()).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
