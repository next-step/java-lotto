package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {
    private final static String ZERO = "0";

    private final static String DEFAULT_SEPARATOR = ",|:";

    private final static String REGEX = "^((\\d+)|(?:[\\,\\:](\\d+)))+$";
    private final static Pattern INPUT_PATTERN = Pattern.compile(REGEX);

    private final static String CUSTOM_REGEX = "//(.)\n(.*)";
    private final static Pattern CUSTOM_INPUT_PATTERN = Pattern.compile(CUSTOM_REGEX);

    private StringSeparator() {
        throw new AssertionError();
    }

    public static String[] split(String input) {

        if (StringUtils.isEmpty(input)) {
            return new String[]{ZERO};
        }
        if (INPUT_PATTERN.matcher(input).matches()) {
            return input.split(DEFAULT_SEPARATOR);
        }

        Matcher customMatcher = CUSTOM_INPUT_PATTERN.matcher(input);

        if (customMatcher.find()) {
            return customSplit(customMatcher);
        }
        throw new IllegalArgumentException();
    }

    private static String[] customSplit(Matcher matcher) {
        String delimiter = matcher.group(matcher.start() + 1);
        String value = matcher.group(matcher.start() + 2);

        valueCheck(value, delimiter);
        return value.split(delimiter);
    }

    private static void valueCheck(String value, String delimiter) {
        String regex = "^((\\d+)|(?:[\\\\" + delimiter + "](\\d+)))+$";

        if (!Pattern.compile(regex).matcher(value).matches()) {
            throw new IllegalArgumentException("잘못된 인수 값입니다.");
        }
    }
}
