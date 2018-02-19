package com.example.demo.mapper;

import com.example.demo.domain.Message;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO fromModelToDTO(User user);

    User fromDTOtoModel(UserDTO user);

    List<UserDTO> fromModelToDTOlist(List<User> users);

    List<User> fromDTOtoModelList(List<UserDTO> userDTOS);

    @AfterMapping
    default void UserToUserId(User user, @MappingTarget UserDTO userDTO){
        userDTO.setListOfFollowedIds(user.getListOfFollowed().stream().map(User::getId).collect(Collectors.toList()));
        userDTO.setListOfFollowersIds(user.getListOfFollowers().stream().map(User::getId).collect(Collectors.toList()));
        userDTO.setListOfMessagesIds(user.getListOfMessages().stream().map(Message::getId).collect(Collectors.toList()));
    }


}
