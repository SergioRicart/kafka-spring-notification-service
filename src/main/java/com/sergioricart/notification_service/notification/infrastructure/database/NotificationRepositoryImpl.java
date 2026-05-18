package com.sergioricart.notification_service.notification.infrastructure.database;

import com.sergioricart.notification_service.notification.domain.port.NotificationRegistryRepository;
import com.sergioricart.notification_service.notification.domain.entity.NotificationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRegistryRepository {

    private final NotificationRegistryRepositoryData notificationRegistryRepositoryData;

    private final NotificationRegistryMapper notificationRegistryMapper;

    @Override
    public void save(NotificationRegistry notification) {

        NotificationRegistryEntity notificationRegistryEntity = notificationRegistryMapper.toNotificationRegistryEntity(notification);

        notificationRegistryRepositoryData.save(notificationRegistryEntity);

    }

}
