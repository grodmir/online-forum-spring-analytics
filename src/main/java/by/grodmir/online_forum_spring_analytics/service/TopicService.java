package by.grodmir.online_forum_spring_analytics.service;

import by.grodmir.online_forum.dto.topic.TopicDto;
import by.grodmir.online_forum_spring_analytics.entity.Topic;
import by.grodmir.online_forum_spring_analytics.mapper.TopicMapper;
import by.grodmir.online_forum_spring_analytics.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    public void createTopic(TopicDto dto) {
        Topic topic = topicMapper.toEntity(dto);
        topicRepository.save(topic);
    }

    public void updateTopic(TopicDto dto) {
        Optional<Topic> existing = topicRepository.findByOriginalId(dto.getId());
        existing.ifPresent(topic -> {
            topicMapper.updateFromDto(dto, topic);
            topicRepository.save(topic);
        });
    }
}
