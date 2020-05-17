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

        if (defaultMatches(input)) {
            return input.split(DEFAULT_SEPARATOR);
        }
        if (customMatches(input)) {
            Matcher matcher = CUSTOM_INPUT_PATTERN.matcher(input);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                String find = matcher.group(2);

                if(delimiterMatches(find, customDelimiter)){
                    return find.split(customDelimiter);
                }
            }
        }
        throw new IllegalArgumentException("올바르지 않은 구분자 입니다.");
    }

    private static boolean defaultMatches(String input) {
        return INPUT_PATTERN.matcher(input).matches();
    }

    private static boolean customMatches(String input) {
        return CUSTOM_INPUT_PATTERN.matcher(input).matches();
    }

    private static boolean delimiterMatches(String input, String delimiter){
        String regex = "^((\\d+)|(?:[\\\\" + delimiter + "](\\d+)))+$";
        return Pattern.compile(regex).matcher(input).matches();
    }
}
