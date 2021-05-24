package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String DELIMITER_REGEX = "//(.)\n(.*)";
    private static final int DELIMITER_MATCHER_GROUP = 1;
    private static final int INPUT_NUMBER_MATCHER_GROUP = 2;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {

        if (!validateInput(input)) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;

        Matcher matcher = Pattern.compile(DELIMITER_REGEX).matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(DELIMITER_MATCHER_GROUP);
            input = matcher.group(INPUT_NUMBER_MATCHER_GROUP);
        }

        int addValue = 0;

        for (String splitNumber : splitDelimiter(input, delimiter)) {
            PositiveNumber positiveNumber = new PositiveNumber(splitNumber);
            addValue = positiveNumber.add(addValue);
        }

        return addValue;
    }

    private static boolean validateInput(String input) {
        return input != null && !input.isEmpty();
    }

    private static String[] splitDelimiter(String beforeSplit, String delimiter) {
        return beforeSplit.split(delimiter);
    }
}
