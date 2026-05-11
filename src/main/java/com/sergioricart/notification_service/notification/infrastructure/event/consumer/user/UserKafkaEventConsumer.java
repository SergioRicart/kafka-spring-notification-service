package com.sergioricart.notification_service.notification.infrastructure.event.consumer.user;

import com.sergioricart.commons.infrastructure.event.consumer.EventSpecificConsumer;
import com.sergioricart.commons.infrastructure.event.util.MessagingUtil;
import com.sergioricart.notification_service.notification.domain.constants.NotificationConstants;
import org.apache.avro.generic.GenericRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import com.sergioricart.commons.infrastructure.event.consumer.KafkaEventConsumer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserKafkaEventConsumer extends KafkaEventConsumer {


    public UserKafkaEventConsumer(List<EventSpecificConsumer> specificConsummers, MessagingUtil messagingUtil) {
        super(specificConsummers, messagingUtil);
    }

    @KafkaListener(topics = NotificationConstants.USER_TOPIC, groupId = "${app.kafka.group-id}", containerFactory = "kafkaListenerContainerFactory")
    @Override
    public void listen(Message<GenericRecord> message) {
        super.accept(message);
    }

}
