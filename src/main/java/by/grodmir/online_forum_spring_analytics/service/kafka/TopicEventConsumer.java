package by.grodmir.online_forum_spring_analytics.service.kafka;

import by.grodmir.online_forum.dto.event.TopicEvent;
import by.grodmir.online_forum_spring_analytics.service.TopicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicEventConsumer {
    private final TopicService topicService;

    @KafkaListener(topics = "topics-events")
    public void handleTopicEvent(TopicEvent event) {
        try {
            switch (event.getEventType()) {
                case "TopicCreated":
                    topicService.createTopic(event.getPayload());
                    log.info("Processed TopicCreated event for ID: {}", event.getPayload().getId());
                    break;
                case "TopicUpdated":
                    topicService.updateTopic(event.getPayload());
                    log.info("Processed TopicUpdated event for ID: {}", event.getPayload().getId());
                    break;
                default:
                    log.warn("Unknown event type: {}", event.getEventType());
            }
        } catch (Exception e) {
            log.error("Error processing event: {}", event, e);
        }
    }
}
