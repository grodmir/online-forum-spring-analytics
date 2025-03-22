package by.grodmir.online_forum_spring_analytics.mapper;

import by.grodmir.online_forum.dto.comment.CommentDto;
import by.grodmir.online_forum_spring_analytics.entity.Comment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentMapper {

    public Comment toEntity(CommentDto dto) {
        return Comment.builder()
                .originalId(dto.getId())
                .content(dto.getContent())
                .author(dto.getUsername())
                .createdAt(dto.getCreatedAt())
                .build();
    }

    public void updateFromDto(Comment comment, CommentDto dto) {
        comment.setContent(dto.getContent());
        comment.setUpdatedAt(LocalDateTime.now());
    }
}
