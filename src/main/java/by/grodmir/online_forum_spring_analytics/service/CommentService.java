package by.grodmir.online_forum_spring_analytics.service;

import by.grodmir.online_forum.dto.comment.CommentDto;
import by.grodmir.online_forum_spring_analytics.entity.Comment;
import by.grodmir.online_forum_spring_analytics.mapper.CommentMapper;
import by.grodmir.online_forum_spring_analytics.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public void createComment(CommentDto dto) {
        Comment comment = commentMapper.toEntity(dto);
        commentRepository.save(comment);
    }

    public void updateComment(CommentDto dto) {
        Optional<Comment> existing = commentRepository.findByOriginalId(dto.getId());
        existing.ifPresent(comment -> {
            commentMapper.updateFromDto(comment, dto);
            commentRepository.save(comment);
        });
    }

}
