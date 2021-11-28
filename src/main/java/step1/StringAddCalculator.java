package step1;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final int ZERO = 0;
    private static final int FIRST = 1;
    private static final int SECOND = 2;
    private static final SumCalculator SUM_CALCULATOR = SumCalculator.getInstance();

    public static int splitAndSum(String inputString) {
        if(isEmptyOrNullText(inputString)) {
            return ZERO;
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(inputString);
        if(isCustomString(matcher)) {
            String[] strings = customStrings(matcher);

            return SUM_CALCULATOR.sumCalculate(strings);
        }

        String[] text = inputString.split(DEFAULT_DELIMITER);
        return SUM_CALCULATOR.sumCalculate(text);
    }

    private static boolean isCustomString(Matcher matcher) {
        return matcher.find();
    }

    private static String[] customStrings(Matcher matcher) {
        String customDelimiter = matcher.group(FIRST);

        return matcher.group(SECOND).split(customDelimiter);
    }

    private static boolean isEmptyOrNullText(String text) {
        return (Objects.isNull(text) || text.trim().isEmpty());
    }
}
