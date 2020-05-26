package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringNumbersParser {

    public static final String COMMA_OR_COLON_REX = ",|:";
    public static final String SPECIAL_DELIMITER_REX = "//(.)\n(.*)";

    static String[] parseNumberString(String numberString) {

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
}
