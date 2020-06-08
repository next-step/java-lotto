package calculator.domain;

import calculator.util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringParser {
    private static final String SPECIFIC_DIVIDER = ",|:";
    private static final String CUSTOM_DIVIDER = "//(.)\n(.*)";

    private StringParser() {}

    public static String[] parse(final String input) {
        if (StringUtil.isEmpty(input)) {
            return new String[]{"0"};
        }

        if (StringUtil.isNumeric(input)) {
            return new String[] {input};
        }

        Matcher matcher = Pattern.compile(CUSTOM_DIVIDER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(SPECIFIC_DIVIDER);
    }
}
