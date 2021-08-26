package org.bmn.jokesender.dao.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.bmn.jokesender.dao.dto.MessageDto;
import org.bmn.jokesender.dao.entity.Message;
import org.bmn.jokesender.dao.mapper.MessageMapper;
import org.bmn.jokesender.dao.repository.MessageRepository;
import org.bmn.jokesender.dao.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    public final MessageMapper messageMapper;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    @Override
    public MessageDto getRandomMessage() {
        MessageDto messageDto = new MessageDto();
        Message message = messageRepository.getRandomMessage();
        messageDto.setText(message.getText());
        log.info("message service -> getRandomMessage: {}", messageDto);
        return messageDto;
    }
}
