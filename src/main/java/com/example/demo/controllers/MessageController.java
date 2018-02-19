package com.example.demo.controllers;

import com.example.demo.common.exceptions.TooLongStringException;
import com.example.demo.dto.MessageDTO;
import com.example.demo.services.message.MessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @ApiOperation(value = "Return a list of messages by given user", notes = "If we want check our messages, we must provide our username as an Path Variable")
    @GetMapping("/{username}")
    public List<MessageDTO> showUserMessages(@PathVariable String username) {
        return messageService.showUserMessages(username);
    }

    @ApiOperation(value = "Returns a list of all messages observed by given user", notes = "If we want return messages of people observed by us, we must provide our username as an Path Variable")
    @GetMapping("/{username}/followed/messages")
    public List<MessageDTO> showFollowedUserMessages(@PathVariable String username) {
        return messageService.showFollowedUserMessages(username);
    }

    @ApiOperation(value = "Adding message by given user", notes = "If we want add messages, we must provide our user name as an Path Variable. In next step we must write content of our message. " +
            "In case if user not exists in database, it is automatically created")
    @PostMapping("/{username}/addMessage")
    public MessageDTO addMessage(@RequestBody String content, @PathVariable String username) throws TooLongStringException {
        return messageService.addMessage(content, username);
    }
}
