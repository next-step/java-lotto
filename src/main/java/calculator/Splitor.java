package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitor {

    public static final Pattern SPLIT_EXPRESSION = Pattern.compile(",|:");
    public static final Pattern CUSTOM_EXPRESSION = Pattern.compile("^//(\\D{1})\\n(.+)");

    public static String[] split(String expression) {
        if(StringUtils.isBlank(expression)) {
            throw new IllegalArgumentException("null 또는 빈문자열은 입력할 수 없습니다.");
        }

        Matcher customMatcher = CUSTOM_EXPRESSION.matcher(expression);
        if(customMatcher.find()) {
            return split(customMatcher);
        }

        return SPLIT_EXPRESSION.split(expression);
    }

    private static String[] split(Matcher customMatcher) {
        String delimeter = customMatcher.group(1);

        StringTokenizer tokenizer = new StringTokenizer(customMatcher.group(2), delimeter);
        String[] values = new String[tokenizer.countTokens()];
        for (int i = 0; i < values.length; i++) {
            values[i] = tokenizer.nextToken();
        }

        return values;
    }

}
