package org.bmn.jokesender.dao.mapper;

import org.bmn.jokesender.dao.dto.MessageDto;
import org.bmn.jokesender.dao.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {

    MessageMapper MESSAGE_MAPPER = Mappers.getMapper(MessageMapper.class);

    Message toMessageDto(MessageDto messageDto);
    MessageDto fromMessage(Message message);
}
