package com.example.demo.services.user;

import com.example.demo.common.exceptions.TheSameFollowedUserException;
import com.example.demo.domain.User;


public interface UserService {

    User userFindOne(String username);

    void followUser(String userDTOList, String userToFollow) throws TheSameFollowedUserException;

    User createUser(String username);

    Boolean checkUser(String username);
}
