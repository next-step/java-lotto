package study;

import java.util.function.BiFunction;

public class Calculator {

    private static final Operation ADDITION = Integer::sum;
    private static final Operation SUBTRACTION = (a, b) -> a - b;
    private static final Operation MULTIPLICATION = (a, b) -> a * b;
    private static final Operation DIVISION = (a, b) -> a / b;

    public static int calculate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("Invalid expression");
        }

        var splitExpression = expression.split(" ");

        int result = 0;
        var operator = ADDITION;

        for (int i = 0; i < splitExpression.length; i++) {
            if (i % 2 == 0) {
                result = operator.apply(result, Integer.parseInt(splitExpression[i]));
            } else {
                switch (splitExpression[i]) {
                    case "+":
                        operator = ADDITION;
                        break;
                    case "-":
                        operator = SUBTRACTION;
                        break;
                    case "*":
                        operator = MULTIPLICATION;
                        break;
                    case "/":
                        operator = DIVISION;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid expression");
                }
            }
        }

        return result;
    }

    interface Operation extends BiFunction<Integer, Integer, Integer> {
        Integer apply(Integer a, Integer b);
    }
}
