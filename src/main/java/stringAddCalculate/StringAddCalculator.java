package stringAddCalculate;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }

        StringExpression stringExpression = new StringExpression(expression);
        String[] numbers = stringExpression.getNumbers();

        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
