package com.sergioricart.notification_service.notification.infrastructure.email;

import com.sergioricart.notification_service.notification.aplication.kafka.user.created.UserCreatedCommand;
import com.sergioricart.notification_service.notification.domain.constants.NotificationConstants;
import com.sergioricart.notification_service.notification.domain.port.NotificationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailNotificationAdapter implements NotificationPort {

    private final JavaMailSender mailSender;

    @Value("${app.mail.from}")
    private String from;

    @Override
    public void sendUserCreatedEmail(String email, String firstName, String lastName) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email);
        message.setSubject("Bienvenido a " + NotificationConstants.APP_NAME);
        message.setText("Hola " + firstName + " " + lastName + ",\n\nTu cuenta ha sido creada correctamente. ¡Bienvenido!");

        mailSender.send(message);
    }

    @Override
    public void sendUserUpdatedEmail(String email, String firstName, String lastName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email);
        message.setSubject("Tu cuenta ha sido actualizada");
        message.setText("Hola " + firstName + " " + lastName + ",\n\nLos datos de tu cuenta han sido actualizados.");

        mailSender.send(message);
    }

    @Override
    public void sendUserPasswordUpdatedEmail(String email, String firstName, String lastName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email);
        message.setSubject("Tu contraseña ha sido actualizada");
        message.setText("Hola " + firstName + " " + lastName + ",\n\nTu contraseña ha sido actualizada.");

        mailSender.send(message);
    }


    @Override
    public void sendUserDeletedEmail(String email, String firstName, String lastName) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email);
        message.setSubject("Tu cuenta ha sido eliminada");
        message.setText("Hola " + firstName + ",\n\nTu cuenta ha sido eliminada de " + NotificationConstants.APP_NAME + ".\n\n¡Hasta luego!");

        mailSender.send(message);

    }

}
