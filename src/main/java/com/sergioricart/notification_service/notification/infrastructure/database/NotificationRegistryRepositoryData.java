package com.sergioricart.notification_service.notification.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRegistryRepositoryData extends JpaRepository<NotificationRegistryEntity, String> {

}
