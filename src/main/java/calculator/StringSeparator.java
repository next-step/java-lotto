package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class StringSeparator {

    private final static String ZERO = "0";

    private final static String DEFAULT_SEPARATOR = ",|:";
    private final static String REGEX = "^((\\d+)|(?:[(\\,\\:](\\d+)))+$";
    private final static Pattern INPUT_PATTERN = Pattern.compile(REGEX);

    private StringSeparator() {
        throw new AssertionError();
    }

    public static String[] split(String input) {

        if (StringUtils.isEmpty(input)) {
            return new String[]{ZERO};
        }

        validate(input);

        return input.split(DEFAULT_SEPARATOR);
    }

    private static void validate(String input) {
        if (!defaultMatches(input)) {
            throw new IllegalArgumentException("올바르지 않은 구분자 입니다.");
        }
    }

    private static boolean defaultMatches(String input) {
        return INPUT_PATTERN.matcher(input).matches();
    }
}
