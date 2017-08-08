package com.jonwelzel.calculator.services;

import com.jonwelzel.calculator.core.Operations;
import com.jonwelzel.calculator.exceptions.InvalidOperatorException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

@Service
public class CalculatorService {
    private static Map<String, BiFunction<Double, Double, Double>> operationsByOperator = new HashMap<>();

    public CalculatorService() {
        operationsByOperator.put("+", Operations.add);
        operationsByOperator.put("-", Operations.subtract);
        operationsByOperator.put("/", Operations.divide);
        operationsByOperator.put("*", Operations.multiply);
    }

    public Double computeResult(Double firstNumber, Double secondNumber, String operator) throws InvalidOperatorException {
        if (!isValidOperator(operator)) {
            throw new InvalidOperatorException(operator);
        }

        return operationsByOperator.get(operator).apply(firstNumber, secondNumber);
    }

    private boolean isValidOperator(String operation) {
        return operation.matches("[-+*/]");
    }
}
