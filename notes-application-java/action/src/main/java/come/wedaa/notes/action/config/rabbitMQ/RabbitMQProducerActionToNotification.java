package come.wedaa.notes.action.config.rabbitMQ;

import come.wedaa.notes.action.config.RabbitMQConfigActionToNotification;
import come.wedaa.notes.action.domain.RabbitMessageModel;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducerActionToNotification {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQProducerActionToNotification.class);

    @Autowired
    private RabbitTemplate template;

    @Scheduled(cron = "0/15 * * * * *")
    public void publishMessage() {
        RabbitMessageModel message = new RabbitMessageModel();
        message.setMessage("Message from action");
        message.setDateTime(new Date());
        template.convertAndSend(RabbitMQConfigActionToNotification.EXCHANGE, RabbitMQConfigActionToNotification.ROUTING_KEY, message);
        logger.info("Published a message with ID: {}, Routing Key: {}", message.getId(), RabbitMQConfigActionToNotification.ROUTING_KEY);
    }
}
