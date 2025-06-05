package com.example.operations.domain;

import java.util.List;
import java.util.Map;

public class SumNode implements OperationNode {
    private final List<OperationNode> inputs;

    public SumNode(List<OperationNode> inputs) {
        this.inputs = inputs;
    }

    public double evaluate(Map<String, Double> sensorValues) {
        return inputs.stream()
                .mapToDouble(node -> node.evaluate(sensorValues))
                .sum();
    }
}
