package org.example.expert.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CommentAdminService : 댓글 관리자 기능을 제공하는 서비스
 */
@Service
@RequiredArgsConstructor
public class CommentAdminService {

    private final CommentRepository commentRepository;

    @Transactional
    public void deleteComment(long commentId) {
        commentRepository.deleteById(commentId);
    }
}
