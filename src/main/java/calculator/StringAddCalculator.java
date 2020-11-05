package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int splitAndSum(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }
        String[] numberStrings = expression.split("[,:]");
        
        return getSum(numberStrings);
    }

    private static int getSum(String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
