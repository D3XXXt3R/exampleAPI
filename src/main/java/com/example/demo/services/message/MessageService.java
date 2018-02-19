package com.example.demo.services.message;

import com.example.demo.common.exceptions.TooLongStringException;
import com.example.demo.dto.MessageDTO;

import java.util.List;


public interface MessageService {

    List<MessageDTO> showUserMessages(String username);

    List<MessageDTO> showFollowedUserMessages(String username);

    MessageDTO addMessage(String content, String username) throws TooLongStringException;
}
