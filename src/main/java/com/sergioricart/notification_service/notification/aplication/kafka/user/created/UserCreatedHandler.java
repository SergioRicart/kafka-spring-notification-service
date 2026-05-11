package com.sergioricart.notification_service.notification.aplication.kafka.user.created;

import com.sergioricart.commons.application.CommandHandler;
import com.sergioricart.commons.application.VoidResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserCreatedHandler implements CommandHandler<UserCreatedCommand, VoidResponse> {

    @Override
    public VoidResponse handle(UserCreatedCommand command) {
        return null;
    }

    @Override
    public Class<UserCreatedCommand> getCommandType() {
        return UserCreatedCommand.class;
    }

}
