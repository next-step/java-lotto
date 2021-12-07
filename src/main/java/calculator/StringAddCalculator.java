package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(expression);
    }
}
