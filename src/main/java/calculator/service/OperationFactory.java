package calculator.service;

import calculator.domain.*;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {
    private static final Map<String, Operation> operations = new HashMap<>();

    static {
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
    }

    public static Operation getOperation(String operator) {
        return operations.get(operator);
    }
}