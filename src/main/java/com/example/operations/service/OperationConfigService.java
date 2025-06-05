package com.example.operations.service;

import com.example.operations.controller.dto.OperationConfigDTO;
import com.example.operations.repository.OperationConfig;
import com.example.operations.repository.OperationConfigRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OperationConfigService {

    private final OperationConfigRepository repository;

    public OperationConfigService(OperationConfigRepository repository) {
        this.repository = repository;
    }

    public OperationConfig save(OperationConfigDTO dto) {
        OperationConfig config = new OperationConfig();
        config.setName(dto.getName());
        config.setConfigJson(dto.getConfigJson());
        config.setActive(dto.isActive());
        config.setCreatedAt(LocalDateTime.now());
        return repository.save(config);
    }

    public List<OperationConfig> findAll() {
        return repository.findAll();
    }

    public OperationConfig findById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
