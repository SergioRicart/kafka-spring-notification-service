package com.sergioricart.notification_service.notification.aplication.kafka.user.created;

import com.sergioricart.commons.application.Command;
import com.sergioricart.commons.application.VoidResponse;
import lombok.Data;

@Data
public class UserCreatedCommand implements Command<VoidResponse> {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
