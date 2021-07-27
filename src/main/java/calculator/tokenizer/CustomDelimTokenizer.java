package calculator.tokenizer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimTokenizer extends Tokenizer {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//([^\\d\\-]{1})\n(.*)$"); // 문자열시작//(숫자나 -가 아닌 아무 문자열 하나)\n(임의의 문자열)문자열끝

    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int EXPRESSION_GROUP_INDEX = 2;

    @Override
    public String[] tokenize(String str) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(str);

        validate(matcher);

        String customDelim = matcher.group(DELIMITER_GROUP_INDEX);
        String expression = matcher.group(EXPRESSION_GROUP_INDEX);

        return expression.split(customDelim);
    }

    private void validate(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException("Token not found.");
        }
    }

    public static boolean isCustomExpression(String str) {
        return CUSTOM_DELIMITER_PATTERN.matcher(str).matches();
    }
}
