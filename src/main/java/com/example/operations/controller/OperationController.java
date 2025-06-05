package com.example.operations.controller;

import com.example.operations.repository.OperationConfig;
import com.example.operations.repository.OperationConfigRepository;
import com.example.operations.domain.OperationNode;
import com.example.operations.domain.OperationParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController()
public class OperationController {
    private final OperationConfigRepository repo;

    public OperationController(OperationConfigRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/evaluate/{configId}")
    public ResponseEntity<Double> evaluate(
            @PathVariable Long configId,
            @RequestBody Map<String, Double> iotData) throws Exception {

        var config = repo.findById(configId).orElseThrow();
        JsonNode tree = new ObjectMapper().readTree(config.getConfigJson());
        OperationNode node = OperationParser.parse(tree);
        double result = node.evaluate(iotData);
        return ResponseEntity.ok(result);
    }
}
