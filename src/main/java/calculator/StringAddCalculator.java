package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        Tokenization tokenization = new Tokenization(expression);
        String[] numbers = tokenization.splitedExpression();

        Validate validate = new Validate();
        validate.validate(numbers);

        return (sum(numbers));
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
