package com.example.demo.dto;

import java.util.List;


public class UserDTO {

    private Long id;
    private String username;
    private List<Long> listOfFollowedIds;
    private List<Long> listOfFollowersIds;
    private List<Long> listOfMessagesIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Long> getListOfFollowedIds() {
        return listOfFollowedIds;
    }

    public void setListOfFollowedIds(List<Long> listOfFollowedIds) {
        this.listOfFollowedIds = listOfFollowedIds;
    }

    public List<Long> getListOfFollowersIds() {
        return listOfFollowersIds;
    }

    public void setListOfFollowersIds(List<Long> listOfFollowersIds) {
        this.listOfFollowersIds = listOfFollowersIds;
    }

    public List<Long> getListOfMessagesIds() {
        return listOfMessagesIds;
    }

    public void setListOfMessagesIds(List<Long> listOfMessagesIds) {
        this.listOfMessagesIds = listOfMessagesIds;
    }
}
