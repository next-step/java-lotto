package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static private final String DELIMITER = ",|:";
    static private final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    static private final int ZERO = 0;

    public static int splitAndSum(final String inputString) {
        if (!validateInputString(inputString)) {
            return ZERO;
        }
        return isMatchWithCustomDelimiter(inputString) ?
                calculateWithCustomDelimiter(inputString) : calculateWithDelimiter(inputString);
    }

    private static boolean validateInputString(final String inputString) {
        return inputString != null && !inputString.isEmpty();
    }

    private static boolean isMatchWithCustomDelimiter(final String inputString) {
        return Pattern.compile(CUSTOM_DELIMITER).matcher(inputString).find();
    }

    private static int calculateWithCustomDelimiter(final String inputString) {
        final Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(inputString);
        if (!m.find()) {
            throw new IllegalArgumentException("Not Match with Custom Calculator");
        }

        final String customDelimiter = m.group(1);
        return AddNumber.newInstance(m.group(2).split(customDelimiter)).sum();
    }

    private static int calculateWithDelimiter(final String inputString) {
        return AddNumber.newInstance(inputString.split(DELIMITER)).sum();
    }
}
