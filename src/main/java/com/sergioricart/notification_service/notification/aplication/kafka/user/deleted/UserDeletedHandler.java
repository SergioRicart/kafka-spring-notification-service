package com.sergioricart.notification_service.notification.aplication.kafka.user.deleted;

import com.sergioricart.commons.application.CommandHandler;
import com.sergioricart.commons.application.VoidResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserDeletedHandler implements CommandHandler<UserDeletedCommand, VoidResponse> {

    @Override
    public VoidResponse handle(UserDeletedCommand command) {
        return null;
    }

    @Override
    public Class<UserDeletedCommand> getCommandType() {
        return UserDeletedCommand.class;
    }

}
