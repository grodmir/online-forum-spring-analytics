package by.grodmir.online_forum_spring_analytics.service.kafka;

import by.grodmir.online_forum.dto.event.CommentEvent;
import by.grodmir.online_forum_spring_analytics.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentEventConsumer {
    private final CommentService commentService;

    @KafkaListener(topics = "comments-events")
    public void handleCommentEvent(CommentEvent event) {
        try {
            switch (event.getEventType()) {
                case "CommentCreated":
                    commentService.createComment(event.getPayload());
                    log.info("Processed CommentCreated event for ID: {}", event.getPayload().getId());
                    break;
                case "CommentUpdated":
                    commentService.updateComment(event.getPayload());
                    log.info("Processed CommentUpdated event for ID: {}", event.getPayload().getId());
                    break;
                default:
                    log.warn("Unknown event type: {}", event.getEventType());
            }
        } catch (Exception e) {
            log.error("Error while processing CommentEvent", e);
        }
    }
}
