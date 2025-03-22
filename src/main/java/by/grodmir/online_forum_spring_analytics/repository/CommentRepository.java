package by.grodmir.online_forum_spring_analytics.repository;

import by.grodmir.online_forum_spring_analytics.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    Optional<Comment> findByOriginalId(int originalId);
}
