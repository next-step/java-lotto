package stringaddcalculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements Separator {
    private static final String CUSTOM_FORMAT = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_FORMAT);
    private static final String PATTERN_NOT_FOUND = "패턴을 찾을 수 없습니다.";
    private static final int DELIMITER_POSITION = 1;
    private static final int REFINE_POSITION = 2;

    @Override
    public String[] splitExpression(String expression) {
        Matcher matcher = CUSTOM_PATTERN.matcher(expression);
        if (!matcher.find()) {
            throw new IllegalArgumentException(PATTERN_NOT_FOUND);
        }
        String customDelimiter = matcher.group(DELIMITER_POSITION);
        String refinedExpression = matcher.group(REFINE_POSITION);
        return refinedExpression.split(customDelimiter);
    }
}
