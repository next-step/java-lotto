package stringcalculator;

import java.util.List;

public class Calculator {

    public static final String DELIMITER = " ";
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIFLY = "*";
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
        validateOrThrow(input);
        return 0;
    }

    private void validateOrThrow(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            this.validateOrThrow(input, i);
        }
    }

    private void validateOrThrow(List<String> input, int i) {
        final String element = input.get(i);
        if (isEven(i)) {
            this.validateInteger(element);
            return;
        }

        validateArithmeticOperator(element);
    }

    private void validateArithmeticOperator(String element) {
        if (element.equals(ADD)) {
            return;
        }

        if (element.equals(SUBTRACT)) {
            return;
        }

        if (element.equals(MULTIFLY)) {
            return;
        }

        if (element.equals(DIVIDE)) {
            return;
        }

        throw new IllegalArgumentException("사칙연산을 수행할 수 없는 문자열을 포함합니다: " + element);
    }

    private void validateInteger(String element) {
        try {
            Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사칙연산을 수행할 수 없는 문자열을 포함합니다: " + element);
        }
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }
}
