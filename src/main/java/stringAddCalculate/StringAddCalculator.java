package stringAddCalculate;

public class StringAddCalculator {

    public static int calculate(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }

        return new NumberExpression(expression).sum();
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
