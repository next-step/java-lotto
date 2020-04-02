public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",";

    public static int splitAndSum(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }

        String[] numbers = expression.split(DEFAULT_DELIMITER);
        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || "".equals(expression);
    }
}
