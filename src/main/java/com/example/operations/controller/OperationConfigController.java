package com.example.operations.controller;

import com.example.operations.controller.dto.OperationConfigDTO;
import com.example.operations.repository.OperationConfig;
import com.example.operations.service.OperationConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configs")
public class OperationConfigController {

    private final OperationConfigService service;

    public OperationConfigController(OperationConfigService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OperationConfig> createConfig(@RequestBody OperationConfigDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public List<OperationConfig> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationConfig> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
