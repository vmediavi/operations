package com.example.operations.domain;

import java.util.Map;

public class SensorInputNode implements OperationNode {
    private final String sensorId;

    public SensorInputNode(String sensorId) {
        this.sensorId = sensorId;
    }

    public double evaluate(Map<String, Double> sensorValues) {
        return sensorValues.getOrDefault(sensorId, 0.0);
    }
}
