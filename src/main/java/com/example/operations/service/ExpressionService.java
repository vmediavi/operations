package com.example.operations.service;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExpressionService {
    private final DoubleEvaluator evaluator = new DoubleEvaluator();

    public double evaluate(String expression, Map<String, Double> variables) {
        final StaticVariableSet<Double> vars = new StaticVariableSet<>();
        variables.forEach(vars::set);

        return evaluator.evaluate(expression, vars);
    }
}