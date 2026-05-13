package com.sergioricart.notification_service.notification.domain.factory;

import com.sergioricart.notification_service.notification.domain.entity.EventType;
import com.sergioricart.notification_service.notification.domain.entity.NotificationRegistry;

import java.time.Instant;
import java.util.UUID;

public class NotificationRegistryFactory {

    private NotificationRegistryFactory() {}

    public static NotificationRegistry forUserCreated(String userId, String email) {
        return base(userId, email, EventType.USER_CREATED).build();
    }

    public static NotificationRegistry forUserUpdated(String userId, String email) {
        return base(userId, email, EventType.USER_UPDATED).build();
    }

    public static NotificationRegistry forUserPasswordUpdated(String userId, String email) {
        return base(userId, email, EventType.USER_PASSWORD_UPDATED).build();
    }

    public static NotificationRegistry forUserDeleted(String userId, String email) {
        return base(userId, email, EventType.USER_DELETED).build();
    }

    private static NotificationRegistry.NotificationRegistryBuilder base(
            String userId,
            String email,
            EventType eventType
    ) {
        return NotificationRegistry.builder()
                .id(UUID.randomUUID().toString())
                .userId(userId)
                .email(email)
                .eventType(eventType)
                .createdAt(Instant.now());
    }
}
