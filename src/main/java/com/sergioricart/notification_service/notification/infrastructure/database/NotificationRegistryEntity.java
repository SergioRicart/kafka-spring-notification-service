package com.sergioricart.notification_service.notification.infrastructure.database;


import com.sergioricart.notification_service.notification.domain.entity.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notification_registry")
public class NotificationRegistryEntity {

    @Id
    private String id;

    private String userId;

    private String email;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private Instant createdAt;


}
