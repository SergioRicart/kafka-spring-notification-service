package com.sergioricart.notification_service.notification.domain.factory;

import com.sergioricart.notification_service.fixtures.NotificationFixture;
import com.sergioricart.notification_service.notification.domain.entity.EventType;
import com.sergioricart.notification_service.notification.domain.entity.NotificationRegistry;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NotificationRegistryFactoryTest {

    @Test
    void forUserCreated_returnsRegistryWithCorrectEventType() {
        NotificationRegistry registry = NotificationRegistryFactory.forUserCreated(
                NotificationFixture.USER_ID, NotificationFixture.EMAIL
        );

        assertThat(registry.getEventType()).isEqualTo(EventType.USER_CREATED);
    }

    @Test
    void forUserUpdated_returnsRegistryWithCorrectEventType() {
        NotificationRegistry registry = NotificationRegistryFactory.forUserUpdated(
                NotificationFixture.USER_ID, NotificationFixture.EMAIL
        );

        assertThat(registry.getEventType()).isEqualTo(EventType.USER_UPDATED);
    }

    @Test
    void forUserDeleted_returnsRegistryWithCorrectEventType() {
        NotificationRegistry registry = NotificationRegistryFactory.forUserDeleted(
                NotificationFixture.USER_ID, NotificationFixture.EMAIL
        );

        assertThat(registry.getEventType()).isEqualTo(EventType.USER_DELETED);
    }

    @Test
    void forUserPasswordUpdated_returnsRegistryWithCorrectEventType() {
        NotificationRegistry registry = NotificationRegistryFactory.forUserPasswordUpdated(
                NotificationFixture.USER_ID, NotificationFixture.EMAIL
        );

        assertThat(registry.getEventType()).isEqualTo(EventType.USER_PASSWORD_UPDATED);
    }

    @Test
    void allFactoryMethods_populateUserIdAndEmail() {
        NotificationRegistry registry = NotificationRegistryFactory.forUserCreated(
                NotificationFixture.USER_ID, NotificationFixture.EMAIL
        );

        assertThat(registry.getUserId()).isEqualTo(NotificationFixture.USER_ID);
        assertThat(registry.getEmail()).isEqualTo(NotificationFixture.EMAIL);
    }

    @Test
    void allFactoryMethods_generateNonNullId() {
        assertThat(NotificationRegistryFactory.forUserCreated("id", "mail@x.com").getId()).isNotNull();
        assertThat(NotificationRegistryFactory.forUserUpdated("id", "mail@x.com").getId()).isNotNull();
        assertThat(NotificationRegistryFactory.forUserDeleted("id", "mail@x.com").getId()).isNotNull();
        assertThat(NotificationRegistryFactory.forUserPasswordUpdated("id", "mail@x.com").getId()).isNotNull();
    }

    @Test
    void allFactoryMethods_generateNonNullCreatedAt() {
        assertThat(NotificationRegistryFactory.forUserCreated("id", "mail@x.com").getCreatedAt()).isNotNull();
        assertThat(NotificationRegistryFactory.forUserUpdated("id", "mail@x.com").getCreatedAt()).isNotNull();
        assertThat(NotificationRegistryFactory.forUserDeleted("id", "mail@x.com").getCreatedAt()).isNotNull();
        assertThat(NotificationRegistryFactory.forUserPasswordUpdated("id", "mail@x.com").getCreatedAt()).isNotNull();
    }

    @Test
    void consecutiveCalls_generateDistinctIds() {
        NotificationRegistry first  = NotificationRegistryFactory.forUserCreated("id", "mail@x.com");
        NotificationRegistry second = NotificationRegistryFactory.forUserCreated("id", "mail@x.com");

        assertThat(first.getId()).isNotEqualTo(second.getId());
    }
}
