package org.bmn.jokesender.dao.repository;

import org.bmn.jokesender.dao.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(nativeQuery = true, value = "select * from message order by random() limit 1")
    Message getRandomMessage();
}
