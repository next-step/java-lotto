package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private static Tokenization tokenization = new Tokenization();

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }
        String[] numbers = tokenization.splitedExpression(expression);

        Validate validate = new Validate();
        validate.validate(numbers);

        return (sum(numbers));
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
