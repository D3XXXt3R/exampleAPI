package com.example.demo.controllers;

import com.example.demo.common.exceptions.TheSameFollowedUserException;
import com.example.demo.services.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Adding a user to the followed", notes = "If we want follow user, we must provide our username and his username in Path Variable (followedUsername)")
    @PutMapping("/{username}/follow/{userToFollow}")
    public void followUser(@PathVariable String username, @PathVariable String userToFollow) throws TheSameFollowedUserException {
        userService.followUser(username, userToFollow);
    }
}
