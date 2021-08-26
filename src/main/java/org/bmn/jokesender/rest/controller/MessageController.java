package org.bmn.jokesender.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.bmn.jokesender.dao.dto.MessageDto;
import org.bmn.jokesender.dao.service.MessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public void getMessage () {
        MessageDto response = messageService.getRandomMessage();
        log.info("controller -> getMessage: {}", response);
        rabbitTemplate.convertAndSend("amq.direct", "tg", Objects.requireNonNullElse(response, "not joke"));
    }
}
