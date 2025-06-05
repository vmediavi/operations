package com.example.operations.domain;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class OperationParser {
    public static OperationNode parse(JsonNode node) {
       if( node.has("operation")){
        String op = node.get("operation").asText();

        if (op.equals("sum")) {
            List<OperationNode> children = new ArrayList<>();
            for (JsonNode input : node.get("inputs")) {
                children.add(parse(input));
            }
            return new SumNode(children);
        } else if (op.equals("average")) {
            List<OperationNode> children = new ArrayList<>();
            for (JsonNode input : node.get("inputs")) {
                children.add(parse(input));
            }
            return new AverageNode(children);
        } }

        else if (node.has("sensorId")) {
            return new SensorInputNode(node.get("sensorId").asText());
        }

        throw new IllegalArgumentException("Unsupported operation: " );
    }
}

