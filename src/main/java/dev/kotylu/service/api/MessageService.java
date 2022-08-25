package dev.kotylu.service.api;

import dev.kotylu.model.MessageModel;
import javassist.NotFoundException;

public interface MessageService {
    MessageModel getMessage(String issueKey) throws NotFoundException;
}
