package com.example.operations.controller;

import com.example.operations.repository.OperationConfigRepository;
import com.example.operations.service.ExpressionService;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
public class OperationController {
    private final OperationConfigRepository repo;
    private final ExpressionService evaluator;

    public OperationController(OperationConfigRepository repo, ExpressionService evaluator) {
        this.repo = repo;
        this.evaluator = evaluator;
    }

    @PostMapping("/evaluate/{id}")
    @ResponseBody
    public double evaluate(@PathVariable Long id, @RequestBody Map<String, Double> variables) {
        var op = repo.findById(id).orElseThrow();
        return evaluator.evaluate(op.getExpression(), variables);
    }
}
