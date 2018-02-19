package com.example.demo.services.user;

import com.example.demo.common.exceptions.TheSameFollowedUserException;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
    }

    @Override
    public User userFindOne(String username) {
        User user = userRepository.findUserByUsername(username);
        return user;
    }

    public void followUser(String username, String userToFollow) throws TheSameFollowedUserException{
        User followedUser = userRepository.findUserByUsername(userToFollow);
        User user = userRepository.findUserByUsername(username);
        Boolean userIsFollowed = user.getListOfFollowed().stream().anyMatch(u -> u.getId().equals(followedUser.getId()));
        if(!userIsFollowed){
            user.getListOfFollowed().add(followedUser);
            userRepository.save(user);
        }
        else{
            throw new TheSameFollowedUserException("You are already following this user");
        }

    }

    public User createUser(String username) {
        User user = new User();
        user.setUsername(username);
        user = userRepository.save(user);
        return user;
    }

    public Boolean checkUser(String username){
        User user = userRepository.findUserByUsername(username);
        Boolean check;
        if(user != null){
            check = true;
        }
        else{
            check = false;
        }
        return check;
    }
}
