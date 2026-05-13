package com.sergioricart.notification_service.notification.aplication.kafka.user.updated;

import com.sergioricart.commons.application.Command;
import com.sergioricart.commons.application.VoidResponse;
import lombok.Data;

@Data
public class UserUpdatedCommand implements Command<VoidResponse> {

    private String id;
    private String firstName;
    private String lastName;
    private String role;
    private String email;

}
