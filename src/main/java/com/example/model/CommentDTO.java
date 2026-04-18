package com.example.model;

public class CommentDTO {
    private String content;
    private String type;
    private Long productId;
    private Long userId;

    // Constructors
    public CommentDTO() {
    }

    public CommentDTO(String content, String type, Long productId, Long userId) {
        this.content = content;
        this.type = type;
        this.productId = productId;
        this.userId = userId;
    }

    // Getters and Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}