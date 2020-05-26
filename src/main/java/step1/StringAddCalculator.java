package step1;

import static step1.ErrorMessages.SHOULD_BE_NUMBER;
import static step1.ErrorMessages.SHOULD_NOT_NEGATIVE_NUMBER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String COMMA_OR_COLON_REX = ",|:";
    public static final String SPECIAL_DELIMITER_REX = "//(.)\n(.*)";

    public static int splitAndSum(String numberString) {
        if (!validateText(numberString)) {
            return 0;
        }

        return addParsedNumberString(parseNumberString(numberString));
    }

    private static Boolean validateText(String numberString) {
        if (numberString == null || numberString.isEmpty()) {
            return false;
        }

        return true;
    }

    private static String[] parseNumberString(String numberString) {

        Matcher specialDelimiterMatcher = Pattern.compile(SPECIAL_DELIMITER_REX)
            .matcher(numberString);

        return specialDelimiterMatcher.find() ?
            parseNumbersWithSpecialDelimiterMatcher(specialDelimiterMatcher) :
            parseNumbersWithNormalDelimiterString(numberString);
    }

    private static String[] parseNumbersWithSpecialDelimiterMatcher(
        Matcher specialDelimiterMatcher) {
        String customDelimiter = specialDelimiterMatcher.group(1);
        return specialDelimiterMatcher.group(2).split(customDelimiter);
    }

    private static String[] parseNumbersWithNormalDelimiterString(String numberString) {
        return numberString.split(COMMA_OR_COLON_REX);
    }

    private static int addParsedNumberString(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += convertStringToInt(number);
        }
        return result;
    }

    private static int convertStringToInt(String number) {
        int value;
        try {
            value = Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException(SHOULD_BE_NUMBER);
        }

        if (value < 0) {
            throw new RuntimeException(SHOULD_NOT_NEGATIVE_NUMBER);
        }
        return value;
    }
}
