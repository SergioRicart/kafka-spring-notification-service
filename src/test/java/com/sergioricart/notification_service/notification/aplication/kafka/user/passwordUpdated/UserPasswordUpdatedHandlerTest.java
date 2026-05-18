package com.sergioricart.notification_service.notification.aplication.kafka.user.passwordUpdated;

import com.sergioricart.commons.application.VoidResponse;
import com.sergioricart.notification_service.fixtures.NotificationFixture;
import com.sergioricart.notification_service.notification.domain.entity.EventType;
import com.sergioricart.notification_service.notification.domain.entity.NotificationRegistry;
import com.sergioricart.notification_service.notification.domain.port.NotificationPort;
import com.sergioricart.notification_service.notification.domain.port.NotificationRegistryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class UserPasswordUpdatedHandlerTest {

    @Mock
    private NotificationPort notificationPort;

    @Mock
    private NotificationRegistryRepository notificationRepository;

    @InjectMocks
    private UserPasswordUpdatedHandler handler;

    @Test
    void handle_givenValidCommand_sendsEmailWithCorrectArguments() {
        handler.handle(NotificationFixture.aUserPasswordUpdatedCommand());

        verify(notificationPort).sendUserPasswordUpdatedEmail(
                NotificationFixture.EMAIL,
                NotificationFixture.FIRST_NAME,
                NotificationFixture.LAST_NAME
        );
        verifyNoMoreInteractions(notificationPort);
    }

    @Test
    void handle_givenValidCommand_savesRegistryWithCorrectEventType() {
        handler.handle(NotificationFixture.aUserPasswordUpdatedCommand());

        ArgumentCaptor<NotificationRegistry> captor = ArgumentCaptor.forClass(NotificationRegistry.class);
        verify(notificationRepository).save(captor.capture());

        NotificationRegistry registry = captor.getValue();
        assertThat(registry.getEventType()).isEqualTo(EventType.USER_PASSWORD_UPDATED);
        assertThat(registry.getUserId()).isEqualTo(NotificationFixture.USER_ID);
        assertThat(registry.getEmail()).isEqualTo(NotificationFixture.EMAIL);
        assertThat(registry.getId()).isNotNull();
        assertThat(registry.getCreatedAt()).isNotNull();
    }

    @Test
    void handle_givenValidCommand_returnsVoidResponse() {
        VoidResponse result = handler.handle(NotificationFixture.aUserPasswordUpdatedCommand());

        assertThat(result).isNotNull();
    }

    @Test
    void getCommandType_returnsUserPasswordUpdatedCommandClass() {
        assertThat(handler.getCommandType()).isEqualTo(UserPasswordUpdatedCommand.class);
    }
}
