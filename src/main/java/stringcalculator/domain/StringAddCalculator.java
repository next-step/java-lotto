package stringcalculator.domain;

public class StringAddCalculator {

    public static long execute(final String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }
        return 0;
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
