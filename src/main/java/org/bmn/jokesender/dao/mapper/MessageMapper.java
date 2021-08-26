package org.bmn.jokesender.dao.mapper;

import org.bmn.jokesender.dao.dto.MessageDto;
import org.bmn.jokesender.dao.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message toMessageDto(MessageDto messageDto);
    MessageDto fromMessage(Message message);
}
