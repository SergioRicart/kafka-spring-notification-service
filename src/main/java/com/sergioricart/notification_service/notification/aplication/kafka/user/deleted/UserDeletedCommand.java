package com.sergioricart.notification_service.notification.aplication.kafka.user.deleted;

import com.sergioricart.commons.application.Command;
import com.sergioricart.commons.application.VoidResponse;
import lombok.Data;

import java.time.Instant;

@Data
public class UserDeletedCommand implements Command<VoidResponse> {

    private String id;
    private Instant timestamp;

}
