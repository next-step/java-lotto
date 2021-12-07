package calculator;

public class StringAddCalculator {

    private static final String TOKEN_DELIMITE = ",|:";

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        String[] numbers = expression.split(TOKEN_DELIMITE);
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
