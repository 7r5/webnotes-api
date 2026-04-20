package com.example.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto para transferir datos de comentarios")
public class CommentDTO {

    @Schema(example = "¡Este producto es genial!")
    private String content;
    
    @Schema(example = "Product", description = "Tipo de entidad relacionada")
    private String type;
    
    @Schema(example = "1")
    private Long productId;
    
    @Schema(example = "10")
    private Long userId;

    // 1. Constructor vacío (OBLIGATORIO para Jackson/Spring)
    public CommentDTO() {}

    // 2. Tu constructor con parámetros
    public CommentDTO(String content, String type, Long productId, Long userId) {
        this.content = content;
        this.type = type;
        this.productId = productId;
        this.userId = userId;
    }

    // 3. Getters y Setters (OBLIGATORIOS para que Spring lea el JSON)
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}