package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private static final int INIT_NUMBER = 0;
    private static final int CRITERIA_NUMBER  = 0;

    private static Tokenization tokenization = new Tokenization();

    private StringAddCalculator() {}

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return INIT_NUMBER;
        }

        String[] numbers = tokenization.splitExpression(expression);
        validate(numbers);

        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }

    private static void validate(String[] numbers) {
        if (negative(numbers)) {
            throw new RuntimeException("음수를 입력 할 수 없습니다.");
        }
    }

    private static boolean negative(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).anyMatch(number -> number < CRITERIA_NUMBER);
    }
}
