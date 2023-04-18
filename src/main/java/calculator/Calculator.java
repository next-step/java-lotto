package calculator;

import calculator.domain.Content;

import java.util.List;

public class Calculator {
    List<Content> contents;

    public Calculator(List<Content> contents) {
        this.contents = contents;
    }

    public int calculate() {
        int result = contents.get(0).getNumber();
        for (int i = 1; i < contents.size(); i += 2) {
            result = calculate(result, contents.get(i + 1).getNumber(), contents.get(i).getOperation());
        }
        return result;
    }

    private int calculate(int number1, int number2, String operation) {
        if ("+".equals(operation)) {
            return add(number1, number2);
        }
        if ("-".equals(operation)) {
            return subtract(number1, number2);
        }
        if ("*".equals(operation)) {
            return multiply(number1, number2);
        }
        if ("/".equals(operation)) {
            return divide(number1, number2);
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    public static int add(int number1, int number2) {
        return number1 + number2;
    }

    public static int subtract(int number1, int number2) {
        return number1 - number2;
    }

    public static int multiply(int number1, int number2) {
        return number1 * number2;
    }

    public static int divide(int number1, int number2) {
        return number1 / number2;
    }
}
