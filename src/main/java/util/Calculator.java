package util;

import domain.Number;
import domain.Operation;
import dto.CalculateRequest;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static String delimiter = " ";

    private Calculator() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Calculates the result of the given expression.
     * @param input The input string to be parsed.
     *              Should be in the format of "number1 operator number2".
     * @return The result of the expression.
     */
    public static int calculate(String input) {
        String[] expressions = parse(input);
        List<Number> numbers = findNumbers(expressions);
        List<Operation> operations = findOperations(expressions);

        int result = numbers.get(0).copyValue();
        for (int i = 0; i < operations.size(); i++) {
            result = operate(new CalculateRequest(new Number(result), numbers.get(i + 1), operations.get(i)));
        }

        return result;
    }

    private static int operate(CalculateRequest request) {
        final int a = request.getNumber1().copyValue();
        final int b = request.getNumber2().copyValue();
        final Operation operation = request.getOperation();

        switch (operation) {
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operation);
        }
    }

    private static String[] parse(String input) {
        verifyNotEmpty(input);
        String[] expressions = input.split(delimiter);
        verifyEven(expressions);
        return expressions;
    }

    private static void verifyNotEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
    }

    private static void verifyEven(String[] expressions) {
        if (expressions.length % 2 == 0) {
            throw new IllegalArgumentException("Invalid expression: " + String.join(delimiter, expressions));
        }
    }

    private static List<Number> findNumbers(String[] expressions) {
        List<Number> numbers = new ArrayList<>();

        for (int i = 0; i < expressions.length; i = i + 2) {
           numbers.add(new Number(expressions[i]));
        }

        return numbers;
    }

    private static List<Operation> findOperations(String[] expressions) {
        List<Operation> operations = new ArrayList<>();

        for (int i = 1; i + 1 < expressions.length; i = i + 2) {
            operations.add(Operation.fromString(expressions[i]));
        }

        return operations;
    }
}
