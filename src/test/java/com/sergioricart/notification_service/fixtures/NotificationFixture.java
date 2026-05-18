package com.sergioricart.notification_service.fixtures;

import com.sergioricart.notification_service.notification.aplication.kafka.user.created.UserCreatedCommand;
import com.sergioricart.notification_service.notification.aplication.kafka.user.deleted.UserDeletedCommand;
import com.sergioricart.notification_service.notification.aplication.kafka.user.passwordUpdated.UserPasswordUpdatedCommand;
import com.sergioricart.notification_service.notification.aplication.kafka.user.updated.UserUpdatedCommand;

import java.time.Instant;

public final class NotificationFixture {

    private NotificationFixture() {}

    // ── Valores base ──────────────────────────────────────────────────────────
    public static final String USER_ID    = "user-123";
    public static final String FIRST_NAME = "Juan";
    public static final String LAST_NAME  = "García";
    public static final String EMAIL      = "juan@example.com";
    public static final String ROLE_ID    = "1";

    // ── Commands ──────────────────────────────────────────────────────────────

    public static UserCreatedCommand aUserCreatedCommand() {
        UserCreatedCommand command = new UserCreatedCommand();
        command.setId(USER_ID);
        command.setFirstName(FIRST_NAME);
        command.setLastName(LAST_NAME);
        command.setEmail(EMAIL);
        return command;
    }

    public static UserUpdatedCommand aUserUpdatedCommand() {
        UserUpdatedCommand command = new UserUpdatedCommand();
        command.setId(USER_ID);
        command.setFirstName(FIRST_NAME);
        command.setLastName(LAST_NAME);
        command.setEmail(EMAIL);
        command.setRoleId(ROLE_ID);
        return command;
    }

    public static UserDeletedCommand aUserDeletedCommand() {
        UserDeletedCommand command = new UserDeletedCommand();
        command.setId(USER_ID);
        command.setFirstName(FIRST_NAME);
        command.setLastName(LAST_NAME);
        command.setEmail(EMAIL);
        command.setTimestamp(Instant.parse("2024-01-15T10:00:00Z"));
        return command;
    }

    public static UserPasswordUpdatedCommand aUserPasswordUpdatedCommand() {
        UserPasswordUpdatedCommand command = new UserPasswordUpdatedCommand();
        command.setId(USER_ID);
        command.setFirstName(FIRST_NAME);
        command.setLastName(LAST_NAME);
        command.setEmail(EMAIL);
        command.setRoleId(ROLE_ID);
        return command;
    }
}
