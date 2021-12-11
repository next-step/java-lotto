package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private StringAddCalculator() {}

    private static final int INIT_NUMBER = 0;
    private static Tokenization tokenization = new Tokenization();

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return INIT_NUMBER;
        }
        String[] numbers = tokenization.splitExpression(expression);

        Validate validate = new Validate();
        validate.validate(numbers);

        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }
}
