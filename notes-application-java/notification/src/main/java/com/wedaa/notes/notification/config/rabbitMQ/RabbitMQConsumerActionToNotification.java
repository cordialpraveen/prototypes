package com.wedaa.notes.notification.config.rabbitMQ;

import com.wedaa.notes.notification.config.RabbitMQConfigActionToNotification;
import com.wedaa.notes.notification.domain.RabbitMessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumerActionToNotification {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumerActionToNotification.class);

    @RabbitListener(queues = RabbitMQConfigActionToNotification.QUEUE)
    public void listener(RabbitMessageModel message) {
        logger.info(
            "Consumed from Queue: {}, Routing Key: {}, Message: {}",
            RabbitMQConfigActionToNotification.QUEUE,
            RabbitMQConfigActionToNotification.ROUTING_KEY,
            message
        );
    }
}
