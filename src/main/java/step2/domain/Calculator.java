package step2.domain;

import java.util.HashMap;
import java.util.Map;

import step2.operator.Addition;
import step2.operator.Division;
import step2.operator.Multiplication;
import step2.operator.Operation;
import step2.operator.Subtraction;

public class Calculator {
    private static final Map<String, Operation> operations = new HashMap<>();

    static {
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
    }

    public static int calculate(ExpressionElement element) {
        int result = element.getElements().get(0);

        for (int i = 0; i < element.getOperators().size(); i++) {
            String operator = element.getOperators().get(i);
            int number = element.getElements().get(i + 1);

            result = calculate(result, number, operator);
        }

        return result;
    }

    private static int calculate(int number1, int number2, String operator) {
        Operation operation = operations.get(operator);

        if (operation == null) {
            throw new IllegalArgumentException("Unsupported operator: " + operator);
        }

        return operation.calculate(number1, number2);
    }
}
