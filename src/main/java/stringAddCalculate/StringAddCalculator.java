package stringAddCalculate;

public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }

        StringExpression stringExpression = new StringExpression(expression);
        String[] numbers = stringExpression.getNumbers();

        int result = 0;
        for (int idx = 0; idx < numbers.length; idx++) {
                result += Integer.parseInt(numbers[idx]);
        }
        return result;
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
