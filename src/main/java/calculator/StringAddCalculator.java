package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        Tokenization tokenization = new Tokenization(expression);

        return sumNumbers(tokenization.splitExpression());
    }

    private static int sumNumbers(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }

}
