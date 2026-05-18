package com.sergioricart.notification_service.notification.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class NotificationRegistry {

    private String id;

    private String userId;

    private String email;

    private EventType eventType;

    private Instant createdAt;

}
