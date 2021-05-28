package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String SEPARATORS = ",|:";
    private static final Pattern CUSTOM_SEPARATORS_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int GROUP_CUSTOM_SEPARATORS_PATTERN = 1;
    private static final int GROUP_NUMBERS = 2;

    public static int splitAndSum(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        return sumNumbersBySeperators(removeCustomSeperatorsString(text), findSeperators(text));
    }

    private static String removeCustomSeperatorsString(String text) {
        Matcher customSeperatorMatcher = CUSTOM_SEPARATORS_PATTERN.matcher(text);
        if (customSeperatorMatcher.find()) {
            return customSeperatorMatcher.group(GROUP_NUMBERS);
        }
        return text;
    }

    private static String findSeperators(String text) {
        Matcher customSeperatorMatcher = CUSTOM_SEPARATORS_PATTERN.matcher(text);
        if (customSeperatorMatcher.find()) {
            return customSeperatorMatcher.group(GROUP_CUSTOM_SEPARATORS_PATTERN);
        }
        return SEPARATORS;
    }

    private static int sumNumbersBySeperators(String text, String seperators) {
        return sum(split(text, seperators));
    }

    private static String[] split(String text, String seperators) {
        return text.split(seperators);
    }

    private static int sum(String[] numbers) {
        StringCalculatorNumber result = new StringCalculatorNumber(0);
        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }
        return result.get();
    }

}
