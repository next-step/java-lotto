package calculator.domain;

import calculator.domain.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperationFactory {
    private static final Map<String, Operation> operations = new HashMap<>();

    static {
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
    }

    public static Operation getOperation(String operator) {
        return Optional.ofNullable(operations.get(operator))
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 연산"));
    }
}