package stringaddcalculator;

import java.util.Objects;

public class StringAddCalculator {
    private static final String REGEX_FORMAT = "[%s]";
    private static final String DELIMITERS = ",:";

    public static int splitAndSum(String input) {
        int result = 0;

        if (isEmptyString(input)) {
            return result;
        }

        String[] splitInput = input.split(String.format(REGEX_FORMAT, DELIMITERS));

        for (String operand : splitInput) {
            result += Integer.parseInt(operand);
        }

        return result;
    }

    private static boolean isEmptyString(String string) {
        return Objects.isNull(string) || string.isEmpty();
    }
}
