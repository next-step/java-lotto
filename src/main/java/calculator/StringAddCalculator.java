package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    private static final Integer BASE_NUMBER_ZERO = 0;
    private static final Integer FIRST_MATCH = 1;
    private static final Integer SECOND_MATCH = 2;

    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public static int splitAndSum(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return BASE_NUMBER_ZERO;
        }

        return Arrays.stream(getStringTokens(inputText))
                .map(StringAddCalculator::parsePositiveInt)
                .reduce(BASE_NUMBER_ZERO, Integer::sum);
    }

    private static String[] getStringTokens(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(FIRST_MATCH);
            return matcher.group(SECOND_MATCH).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER_REGEX);
    }

    private static int parsePositiveInt(String text) {
        int parsedInt = Integer.parseInt(text);
        if (parsedInt < BASE_NUMBER_ZERO) {
            throw new AllowedOnlyPositiveNumberException();
        }
        return parsedInt;
    }
}
