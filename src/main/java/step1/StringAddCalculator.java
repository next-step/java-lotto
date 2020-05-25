package step1;

import static step1.Constants.COMMA_OR_COLON_REX;
import static step1.Constants.SPECIAL_DELIMITER_REX;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String numberString) {
        if (!validateText(numberString)) {
            return 0;
        }

        int addParsedNumberString = addParsedNumberString(parseNumberString(numberString));

        return addParsedNumberString;
    }

    private static Boolean validateText(String numberString) {
        if (numberString == null) {
            return false;
        }

        if (numberString.isEmpty()) {
            return false;
        }

        return true;
    }

    private static String[] parseNumberString(String numberString) {

        Matcher specialDelimiterMatcher = Pattern.compile(SPECIAL_DELIMITER_REX)
            .matcher(numberString);

        return specialDelimiterMatcher.find() ?
            parseNumbersWithSpecialDelimiter(specialDelimiterMatcher) :
            parseNumbersWithNormalDelimiter(numberString);
    }

    private static String[] parseNumbersWithSpecialDelimiter(Matcher specialDelimiterMatcher) {
        String customDelimiter = specialDelimiterMatcher.group(1);
        return specialDelimiterMatcher.group(2).split(customDelimiter);
    }

    private static String[] parseNumbersWithNormalDelimiter(String numberString) {
        return numberString.split(COMMA_OR_COLON_REX);
    }

    private static int addParsedNumberString(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
