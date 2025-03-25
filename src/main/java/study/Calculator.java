package study;

import java.util.function.BiFunction;

public class Calculator {

    private static final Operation ADDITION = Integer::sum;
    private static final Operation SUBTRACTION = (a, b) -> a - b;

    public static int calculate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("Invalid expression");
        }

        var replacedExpression = expression.replace(" ", "");

        if (replacedExpression.contains("+")) {
            String[] parts = replacedExpression.split("\\+");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            return ADDITION.apply(a, b);
        } else if (replacedExpression.contains("-")) {
            String[] parts = replacedExpression.split("-");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            return SUBTRACTION.apply(a, b);
        } else if (replacedExpression.contains("*")) {
            String[] parts = replacedExpression.split("\\*");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            return a * b;
        } else if (replacedExpression.contains("/")) {
            String[] parts = replacedExpression.split("/");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            return a / b;
        } else {
            throw new IllegalArgumentException("Invalid expression");
        }
    }

    interface Operation extends BiFunction<Integer, Integer, Integer> {
        Integer apply(Integer a, Integer b);
    }
}
