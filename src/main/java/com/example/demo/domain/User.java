package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @ManyToMany
    @JoinTable(name="followedTable")
    private List<User> listOfFollowed;

    @ManyToMany
    @JoinTable(name="followerTable")
    private List<User> listOfFollowers;


    @OneToMany(mappedBy = "user")
    private List<Message> listOfMessages;

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

    public List<User> getListOfFollowed() {
        return listOfFollowed;
    }

    public void setListOfFollowed(List<User> listOfFollowed) {
        this.listOfFollowed = listOfFollowed;
    }

    public List<User> getListOfFollowers() {
        return listOfFollowers;
    }

    public void setListOfFollowers(List<User> listOfFollowers) {
        this.listOfFollowers = listOfFollowers;
    }

    public List<Message> getListOfMessages() {
        return listOfMessages;
    }

    public void setListOfMessages(List<Message> listOfMessages) {
        this.listOfMessages = listOfMessages;
    }
}
