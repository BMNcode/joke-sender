package org.bmn.jokesender.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.bmn.jokesender.dao.dto.MessageDto;
import org.bmn.jokesender.dao.service.MessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Objects;

@RestController
@RequestMapping("/")
@Slf4j
public class MessageController {

    private final MessageService messageService;
    public final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageController(MessageService messageService, RabbitTemplate rabbitTemplate) {
        this.messageService = messageService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public void triggerMessage (@RequestBody Update update) {
        log.info("controller -> old update: {}", update);

        MessageDto response = messageService.getRandomMessage();

        Message message = update.getMessage();
        message.setText(response.getText());
        update.setMessage(message);
        log.info("controller -> new update: {}", update);

        rabbitTemplate.convertAndSend("amq.direct", "tg", Objects.requireNonNullElse(update, "not joke"));
    }
}
