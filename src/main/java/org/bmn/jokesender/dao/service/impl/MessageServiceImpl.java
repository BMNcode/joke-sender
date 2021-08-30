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

@Service("messageservice")
@Transactional
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageDto getRandomMessage() {
        Message message = messageRepository.getRandomMessage();
        MessageDto messageDto = new MessageDto();
        messageDto.setText(message.getText());
        log.info("message service -> getRandomMessage: {}", messageDto);
        return messageDto;
    }
}
