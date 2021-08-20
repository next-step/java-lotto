package edu.nextstep.stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_DELIMITER_INPUT_STRING = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_INPUT_STRING);

    // 기본 생성자가 만들어지는 것을 방지한다.(인스턴스화 방지용)
    private StringAddCalculator() {
        throw new AssertionError();
    }

    public static int splitAndSum(String inputString) {
        if (isNullOrEmpty(inputString)) {
            return 0;
        }

        TargetNumbers targetNumbers = TargetNumbers.from(checkCustomDelimiterAndGetSplitNumberString(inputString));

        return targetNumbers.sum();
    }

    private static String[] checkCustomDelimiterAndGetSplitNumberString(String inputString) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(inputString);

        if (matcher.find()) {
            Delimiters delimiters = Delimiters.create(matcher.group(1));
            return matcher.group(2).split(delimiters.regex());
        }

        Delimiters delimiters = Delimiters.create();
        return inputString.split(delimiters.regex());
    }

    private static boolean isNullOrEmpty(String inputString) {
        return inputString == null || inputString.isEmpty() || inputString.trim().isEmpty();
    }
}
