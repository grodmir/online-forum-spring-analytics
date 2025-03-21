package by.grodmir.online_forum_spring_analytics.mapper;

import by.grodmir.online_forum.dto.topic.TopicDto;
import by.grodmir.online_forum_spring_analytics.entity.Topic;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TopicMapper {

    public Topic toEntity(TopicDto dto) {
        return Topic.builder()
                .originalId(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(dto.getAuthor())
                .createdAt(LocalDateTime.parse(dto.getCreatedAt()))
                .build();

    }

    public void updateFromDto(TopicDto dto, Topic topic) {
        topic.setTitle(dto.getTitle());
        topic.setContent(dto.getContent());
        topic.setUpdatedAt(LocalDateTime.now());
    }
}
