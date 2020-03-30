package stringaddcalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String REGEX_FORMAT = "[%s]";
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String CUSTOM_FORMAT = "\\/\\/(.*)\\n(.*)";

    public static int splitAndSum(String input) {
        int result = 0;

        if (isEmptyString(input)) {
            return result;
        }

        Pattern pattern = Pattern.compile(CUSTOM_FORMAT);

        Matcher matcher = pattern.matcher(input);
        String delimiters = DEFAULT_DELIMITERS;
        if (matcher.find()) {
            delimiters += matcher.group(1);
            input = matcher.group(2);
        }

        String[] splitInput = input.split(String.format(REGEX_FORMAT, delimiters));

        for (String operand : splitInput) {
            result += Integer.parseInt(operand);
        }

        return result;
    }

    private static boolean isEmptyString(String string) {
        return Objects.isNull(string) || string.isEmpty();
    }
}
