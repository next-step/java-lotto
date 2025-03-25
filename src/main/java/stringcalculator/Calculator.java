package stringcalculator;

import java.util.List;

public class Calculator {

    public static final String DELIMITER = " ";
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public List<String> splitWithSpace(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 문자열입니다: " + input);
        }

        return List.of(input.split(DELIMITER));
    }

    public int process(List<String> input) {
        int result = this.parseOrThrow(input.get(0));

        for (int i = 1; i < input.size(); i = i + 2) {
            int number = this.parseOrThrow(input.get(i + 1));
            result = this.operate(input.get(i), result, number);
        }

        return result;
    }

    private int operate(String operator, int a, int b) {
        if (operator.equals(ADD)) {
            return add(a, b);
        }

        if (operator.equals(SUBTRACT)) {
            return subtract(a, b);
        }

        if (operator.equals(MULTIPLY)) {
            return multiply(a, b);
        }

        if (operator.equals(DIVIDE)) {
            return divide(a, b);
        }

        throw new IllegalArgumentException("사칙연산을 수행할 수 없는 문자열을 포함합니다: " + operator);
    }

    private int parseOrThrow(String element) {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사칙연산을 수행할 수 없는 문자열을 포함합니다: " + element);
        }
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }
}
