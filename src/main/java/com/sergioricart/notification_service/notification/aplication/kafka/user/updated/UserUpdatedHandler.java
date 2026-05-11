package com.sergioricart.notification_service.notification.aplication.kafka.user.updated;

import com.sergioricart.commons.application.CommandHandler;
import com.sergioricart.commons.application.VoidResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserUpdatedHandler implements CommandHandler<UserUpdatedCommand, VoidResponse> {

    @Override
    public VoidResponse handle(UserUpdatedCommand command) {
        return null;
    }

    @Override
    public Class<UserUpdatedCommand> getCommandType() {
        return UserUpdatedCommand.class;
    }

}
