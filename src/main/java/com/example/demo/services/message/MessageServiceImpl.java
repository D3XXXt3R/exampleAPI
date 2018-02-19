package com.example.demo.services.message;

import com.example.demo.common.exceptions.TooLongStringException;
import com.example.demo.domain.Message;
import com.example.demo.domain.User;
import com.example.demo.mapper.MessageMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.dto.MessageDTO;
import com.example.demo.repositories.MessageRepository;
import com.example.demo.services.user.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserService userService;
    private final MessageMapper messageMapper;
    private final UserMapper userMapper;

    public MessageServiceImpl(MessageRepository messageRepository, UserService userService, MessageMapper messageMapper, UserMapper userMapper) {
        this.messageRepository = messageRepository;
        this.userService = userService;
        this.messageMapper = messageMapper;
        this.userMapper = userMapper;
    }

    @Override
    public MessageDTO addMessage(String content, String username) throws TooLongStringException {
        if(content.length() <= 140) {
            User user;
            Message message = new Message();
            LocalDateTime today = LocalDateTime.now();
            message.setContent(content);
            message.setDate(today);
            if (!userService.checkUser(username)) {
                user = userService.createUser(username);
            } else {
                user = userService.userFindOne(username);
            }
            message.setUser(user);
            message = messageRepository.save(message);
            return messageMapper.fromModelToDTO(message);
        }
        else {
            throw new TooLongStringException("Message must have a maximum of 140 characters");
        }
    }

    @Override
    public List<MessageDTO> showUserMessages(String username) {
        List<Message> messages;
        User user = userService.userFindOne(username);
        messages = messageRepository.findByUser(user);
        messages = messages.stream().sorted(Comparator.comparing(Message::getDate).reversed()).collect(Collectors.toList());
        return messageMapper.fromModelToDTOlist(messages);
    }

    @Override
    public List<MessageDTO> showFollowedUserMessages(String username) {
        User user = userService.userFindOne(username);
        List<Long> followedUsersIds = user.getListOfFollowed().stream().map(User::getId).collect(Collectors.toList());
        List<Message> allMessages = messageRepository.findAllMessagesFromUserIds(followedUsersIds);
        allMessages = allMessages.stream().sorted(Comparator.comparing(Message::getDate).reversed()).collect(Collectors.toList());
        return messageMapper.fromModelToDTOlist(allMessages);
    }
}
