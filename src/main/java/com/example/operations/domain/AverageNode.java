package com.example.operations.domain;

import java.util.List;
import java.util.Map;

public class AverageNode implements OperationNode {
    private final List<OperationNode> inputs;

    public AverageNode(List<OperationNode> inputs) {
        this.inputs = inputs;
    }

    public double evaluate(Map<String, Double> sensorValues) {
        return inputs.stream()
                .mapToDouble(node -> node.evaluate(sensorValues))
                .average().orElse(0.0);
    }
}
