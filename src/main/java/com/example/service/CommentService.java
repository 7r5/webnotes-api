package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Comment;
import com.example.model.CommentDTO;
import com.example.model.Product;
import com.example.model.Users;
import com.example.repository.CommentRepository;
import com.example.repository.ProductRepository;
import com.example.repository.UsersRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UsersRepository usersRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment saveCommentFromDTO(CommentDTO dto) {
        Product product = productRepository.findById(dto.getProductId()).orElse(null);
        Users user = usersRepository.findById(dto.getUserId()).orElse(null);

        Comment comment = new Comment(dto.getContent(), dto.getType(), product, user);
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByProductId(Long productId) {
        return commentRepository.findByProduct_Id(productId);
    }

    public List<Comment> getCommentsByType(String type) {
        return commentRepository.findByType(type);
    }

    public List<Comment> getCommentsByProductAndType(Long productId, String type) {
        return commentRepository.findByProduct_IdAndType(productId, type);
    }

   public Comment updateCommentFull(Long id, CommentDTO dto) {
    // 1. Buscar el comentario existente
    Comment comment = commentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));

    // 2. Actualizar contenido si no es nulo
    if (dto.getContent() != null) {
        comment.setContent(dto.getContent());
    }

    // 3. Actualizar tipo si no es nulo
    if (dto.getType() != null) {
        comment.setType(dto.getType());
    }

    // 4. Actualizar relación con Producto (Debug mode)
    if (dto.getProductId() != null) {
        // Asumiendo que tienes un productRepository
        Product product = productRepository.findById(dto.getProductId())
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        comment.setProduct(product);
    }

    // 5. Actualizar relación con Usuario (Debug mode)
    if (dto.getUserId() != null) {
        // Asumiendo que tienes un userRepository
        Users user = usersRepository.findById(dto.getUserId())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        comment.setUser(user);
    }

    return commentRepository.save(comment);
}
}
