package com.example.operations.domain;

import java.util.Map;

public interface OperationNode {
    double evaluate(Map<String, Double> sensorValues);
}
