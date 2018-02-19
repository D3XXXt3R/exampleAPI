package com.example.demo.mapper;

import com.example.demo.domain.Message;
import com.example.demo.dto.MessageDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    MessageDTO fromModelToDTO(Message message);

    Message fromDTOtoModel(MessageDTO messageDTO);

    List<MessageDTO> fromModelToDTOlist(List<Message> messages);

    List<Message> fromDTOtoModelList(List<MessageDTO> messageDTOS);

    @AfterMapping
    default void userToUserId(Message message, @MappingTarget MessageDTO messageDTO){
        messageDTO.setUserId(message.getUser().getId());
    }
}
