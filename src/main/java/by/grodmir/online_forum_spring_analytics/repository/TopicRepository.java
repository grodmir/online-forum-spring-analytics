package by.grodmir.online_forum_spring_analytics.repository;

import by.grodmir.online_forum_spring_analytics.entity.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends MongoRepository<Topic, String> {
    Optional<Topic> findByOriginalId(int originalId);
}
