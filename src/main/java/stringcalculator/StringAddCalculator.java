package stringcalculator;

public class StringAddCalculator {
    private static final int DEFAULT_RETURN_VALUE = 0;
    private static final String DEFAULT_DELIMITER = ",";

    public static int splitAndSum(String text) {
        if (validateNullOrEmpty(text)) {
            return DEFAULT_RETURN_VALUE;
        }
        return getSumStringNumbers(text);
    }

    private static int getSumStringNumbers(String numbers) {
        int sumNumbers = DEFAULT_RETURN_VALUE;
        for (String number : numbers.split(DEFAULT_DELIMITER)) {
            sumNumbers += Integer.parseInt(number);
        }
        return sumNumbers;
    }

    private static boolean validateNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }
}
