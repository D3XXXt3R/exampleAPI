package com.example.demo.mapper;

import com.example.demo.domain.Message;
import com.example.demo.domain.User;
import com.example.demo.dto.MessageDTO;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class MessageMapperTest {

    public static final Long ID = 1L;
    public static final String CONTENT = "TEST TEST";
    public static final LocalDateTime TODAY = LocalDateTime.now();
    public static final List<Message> MESSAGES = new ArrayList<>();

    private MessageMapper messageMapper = MessageMapper.INSTANCE;

    @Before
    public void setUp() throws Exception {
        Message message = new Message();
        message.setId(ID);
        MESSAGES.add(message);
    }

    @Test
    public void fromModelToDTO() throws Exception {
        User user = new User();
        user.setId(ID);

        Message message = new Message();
        message.setId(ID);
        message.setContent(CONTENT);
        message.setDate(TODAY);
        message.setUser(user);

        MessageDTO messageDTO = messageMapper.fromModelToDTO(message);

        assertEquals(ID, messageDTO.getId());
        assertEquals(CONTENT, messageDTO.getContent());
        assertEquals(TODAY, messageDTO.getDate());
        assertEquals(ID, messageDTO.getUserId());

    }
}