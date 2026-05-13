package com.sergioricart.notification_service.notification.aplication.kafka.user.created;

import com.sergioricart.commons.application.CommandHandler;
import com.sergioricart.commons.application.VoidResponse;
import com.sergioricart.notification_service.notification.domain.port.NotificationRegistryRepository;
import com.sergioricart.notification_service.notification.domain.entity.NotificationRegistry;
import com.sergioricart.notification_service.notification.domain.factory.NotificationRegistryFactory;
import com.sergioricart.notification_service.notification.domain.port.NotificationPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserCreatedHandler implements CommandHandler<UserCreatedCommand, VoidResponse> {

    private final NotificationPort notificationPort;

    private final NotificationRegistryRepository notificationRepository;

    @Override
    public VoidResponse handle(UserCreatedCommand command) {

        log.info("Enviando notificacion de usuario creado: {}", command.toString());

        notificationPort.sendUserCreatedEmail(command.getEmail(), command.getFirstName(), command.getLastName());

        NotificationRegistry notificationRegistry = NotificationRegistryFactory.forUserCreated(command.getId(), command.getEmail());

        notificationRepository.save(notificationRegistry);

        return new VoidResponse();
    }

    @Override
    public Class<UserCreatedCommand> getCommandType() {
        return UserCreatedCommand.class;
    }

}
