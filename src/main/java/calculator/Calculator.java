package calculator;

import java.util.Arrays;

public class Calculator {
    public int add(String expression) {
        validateNull(expression);
        validateBlank(expression);
        String[] split = expression.split(" ");
        return Arrays.stream(split)
                .filter(i -> !i.equals("+"))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public int substract(String expression) {
        validateNull(expression);
        validateBlank(expression);
        String[] split = expression.split(" ");
        int beforeOperation = 0;
        boolean substraction = false;
        for (String s : split) {
            if (substraction) {
                beforeOperation = beforeOperation - Integer.parseInt(s);
                substraction = false;
                continue;
            }
            if (s.equals("-")) {
                substraction = true;
                continue;
            }
            beforeOperation = Integer.parseInt(s);
        }
        return beforeOperation;
    }

    public int multiply(String expression) {
        validateNull(expression);
        validateBlank(expression);
        String[] split = expression.split(" ");
        int beforeOperation = 0;
        boolean multiplication = false;
        for (String s : split) {
            if (multiplication) {
                beforeOperation *= Integer.parseInt(s);
                multiplication = false;
                continue;
            }
            if (s.equals("*")) {
                multiplication = true;
                continue;
            }
            beforeOperation = Integer.parseInt(s);
        }
        return beforeOperation;
    }

    public int divide(String expression) {
        validateNull(expression);
        validateBlank(expression);
        String[] split = expression.split(" ");
        int beforeOperation = 0;
        boolean division = false;
        for (String s : split) {
            if (division) {
                double floatNum = (double) beforeOperation / Integer.parseInt(s);
                beforeOperation = beforeOperation / Integer.parseInt(s);
                if (floatNum != beforeOperation) {
                    throw new ArithmeticException("나누어 떨어지지 않는 값을 입력하셨습니다.");
                }
                division = false;
                continue;
            }
            if (s.equals("/")) {
                division = true;
                continue;
            }
            beforeOperation = Integer.parseInt(s);
        }
        return beforeOperation;
    }

    private void validateNull(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
    }

    private void validateBlank(String expression) {
        if (expression.isBlank()) {
            throw new IllegalArgumentException("입력값이 공백입니다.");
        }
    }
}
