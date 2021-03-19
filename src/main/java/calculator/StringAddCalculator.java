package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        int sum = 0;

        if (isEmptyOrNull(expression)) {
            return sum;
        }

        return sum;
    }

    private static boolean isEmptyOrNull(String expression) {
        return expression == null || expression.isEmpty();
    }
}
