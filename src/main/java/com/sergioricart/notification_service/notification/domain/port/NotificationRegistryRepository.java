package com.sergioricart.notification_service.notification.domain.port;

import com.sergioricart.notification_service.notification.domain.entity.NotificationRegistry;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRegistryRepository {

    void save(NotificationRegistry notification);
}
