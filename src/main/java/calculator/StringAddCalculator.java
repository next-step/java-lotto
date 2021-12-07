package calculator;

public class StringAddCalculator {

    private static final String TOKEN_DELIMITER = ",|:";

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        String[] numbers = expression.split(TOKEN_DELIMITER);
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
