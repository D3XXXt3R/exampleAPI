package com.example.demo.repositories;

import com.example.demo.domain.Message;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByUser(User user);

    @Query("Select m from Message as m where m.user.id in :userIds")
    List<Message> findAllMessagesFromUserIds(@Param("userIds") List<Long> usersIds);
}
