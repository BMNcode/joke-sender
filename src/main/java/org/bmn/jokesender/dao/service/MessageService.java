package org.bmn.jokesender.dao.service;

import org.bmn.jokesender.dao.dto.MessageDto;

public interface MessageService {

    MessageDto getRandomMessage();
}
