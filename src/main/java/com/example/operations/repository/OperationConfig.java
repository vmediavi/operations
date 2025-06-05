package com.example.operations.repository;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "operation_config")
public class OperationConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String expression;

    private boolean active;

    private LocalDateTime createdAt;
    public Long getId() {
        return id;
    }

    public OperationConfig setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OperationConfig setName(String name) {
        this.name = name;
        return this;
    }

    public String getExpression() {
        return expression;
    }

    public OperationConfig setExpression(String expression) {
        this.expression = expression;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public OperationConfig setActive(boolean active) {
        this.active = active;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public OperationConfig setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }


}
