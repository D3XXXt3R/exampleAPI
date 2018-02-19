package com.example.demo.mapper;

import com.example.demo.domain.Message;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {

    public static final Long ID = 1L;
    public static final String USERNAME = "Nick";
    public static final List<User> FOLLOWED_USERS = new ArrayList<>();
    public static final List<User> FOLLOWERS = new ArrayList<>();
    public static final List<Message> MESSAGES = new ArrayList<>();

    private UserMapper userMapper = UserMapper.INSTANCE;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setId(ID);
        FOLLOWED_USERS.add(user);

        FOLLOWERS.add(user);

        Message message = new Message();
        message.setId(ID);
        MESSAGES.add(message);
    }

    @Test
    public void fromModelToDTO() throws Exception {
        User user = new User();
        user.setId(ID);
        user.setUsername(USERNAME);
        user.setListOfFollowed(FOLLOWED_USERS);
        user.setListOfFollowers(FOLLOWERS);
        user.setListOfMessages(MESSAGES);


        UserDTO userDTO = userMapper.fromModelToDTO(user);

        assertEquals(ID, userDTO.getId());
        assertEquals(USERNAME, userDTO.getUsername());
        assertEquals(1, userDTO.getListOfFollowedIds().size());
        assertEquals(1, userDTO.getListOfFollowersIds().size());
        assertEquals(1, userDTO.getListOfMessagesIds().size());

    }

}