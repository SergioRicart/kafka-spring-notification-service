package com.sergioricart.notification_service.notification.aplication.kafka.user.passwordUpdated;

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
public class UserPasswordUpdatedHandler implements CommandHandler<UserPasswordUpdatedCommand, VoidResponse> {

    private final NotificationPort notificationPort;

    private final NotificationRegistryRepository notificationRepository;

    @Override
    public VoidResponse handle(UserPasswordUpdatedCommand command) {

        log.info("Usuario actualizado: {}", command);

        notificationPort.sendUserPasswordUpdatedEmail(command.getEmail(), command.getFirstName(), command.getLastName());

        NotificationRegistry notificationRegistry = NotificationRegistryFactory.forUserPasswordUpdated(command.getId(), command.getEmail());

        notificationRepository.save(notificationRegistry);

        return new VoidResponse();
    }

    @Override
    public Class<UserPasswordUpdatedCommand> getCommandType() {
        return UserPasswordUpdatedCommand.class;
    }

}
