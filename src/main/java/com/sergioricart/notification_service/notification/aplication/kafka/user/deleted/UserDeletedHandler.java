package com.sergioricart.notification_service.notification.aplication.kafka.user.deleted;

import com.sergioricart.commons.application.CommandHandler;
import com.sergioricart.commons.application.VoidResponse;
import com.sergioricart.notification_service.notification.domain.entity.NotificationRegistry;
import com.sergioricart.notification_service.notification.domain.factory.NotificationRegistryFactory;
import com.sergioricart.notification_service.notification.domain.port.NotificationPort;
import com.sergioricart.notification_service.notification.domain.port.NotificationRegistryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserDeletedHandler implements CommandHandler<UserDeletedCommand, VoidResponse> {

    private final NotificationPort notificationPort;

    private final NotificationRegistryRepository notificationRepository;

    @Override
    public VoidResponse handle(UserDeletedCommand command) {

        log.info("Enviando notificacion de usuario creado: {}", command.toString());

        notificationPort.sendUserDeletedEmail(command.getEmail(), command.getFirstName(), command.getLastName());

        NotificationRegistry notificationRegistry = NotificationRegistryFactory.forUserDeleted(command.getId(), command.getEmail());

        notificationRepository.save(notificationRegistry);

        return new VoidResponse();
    }

    @Override
    public Class<UserDeletedCommand> getCommandType() {
        return UserDeletedCommand.class;
    }

}
