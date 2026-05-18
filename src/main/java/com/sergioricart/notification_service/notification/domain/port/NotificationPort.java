package com.sergioricart.notification_service.notification.domain.port;

public interface NotificationPort {

    void sendUserCreatedEmail(String email, String firstName, String lastName);

    void sendUserUpdatedEmail(String email, String firstName, String lastName);

    void sendUserPasswordUpdatedEmail(String email, String firstName, String lastName);


    void sendUserDeletedEmail(String email, String firstName, String lastName);


}
