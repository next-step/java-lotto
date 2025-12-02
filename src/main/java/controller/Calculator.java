package controller;

public class Calculator {
    public Calculator(String expression) {
        if (!isValidExpression(expression)) {
            throw new IllegalArgumentException("유표하지 않은 수식입니다.");
        }
    }

    private static boolean isValidExpression(String expression) {
        return expression != null && !expression.isBlank();
    }
}
