package com.sergioricart.notification_service.notification.infrastructure.database;

import com.sergioricart.notification_service.notification.domain.entity.NotificationRegistry;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface NotificationRegistryMapper {

    NotificationRegistryEntity toNotificationRegistryEntity(NotificationRegistry notificationRegistry);

}
