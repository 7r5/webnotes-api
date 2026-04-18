package com.example.service;

import com.example.model.Comment;
import com.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByProductId(Long productId) {
        return commentRepository.findByProductId(productId);
    }

    public List<Comment> getCommentsByType(String type) {
        return commentRepository.findByType(type);
    }

    public List<Comment> getCommentsByProductAndType(Long productId, String type) {
        return commentRepository.findByProductIdAndType(productId, type);
    }
}