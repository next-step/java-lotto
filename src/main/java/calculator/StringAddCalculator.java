package calculator;

public class StringAddCalculator {

    private static final int DEFAULT_SUM_NUMBER = 0;
    private static final String SEPARATOR_COMMA = ",";

    public static int splitAndSum(String input) {
        if (!validationCheck(input)) {
            return DEFAULT_SUM_NUMBER;
        }

        return addNumbers(input);
    }

    private static int addNumbers(String input) {
        int sum = DEFAULT_SUM_NUMBER;

        String[] splitedText = input.split(SEPARATOR_COMMA);
        for (String text : splitedText) {
            sum += Integer.parseInt(text);
        }

        return sum;
    }

    private static boolean validationCheck(String input) {
        if (input == null) {
            return false;
        }

        if (input.isEmpty()) {
            return false;
        }
        return true;
    }


}
