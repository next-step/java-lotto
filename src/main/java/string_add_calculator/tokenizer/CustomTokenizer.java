package string_add_calculator.tokenizer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomTokenizer implements Tokenizer {
    private static final Pattern CUSTOM_EXPRESSION_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int EXPRESSION_GROUP_INDEX = 2;

    @Override
    public String[] split(String inputString) {
        Matcher matcher = CUSTOM_EXPRESSION_PATTERN.matcher(inputString);

        validate(matcher);

        String customDelimiter = matcher.group(DELIMITER_GROUP_INDEX);
        String expression = matcher.group(EXPRESSION_GROUP_INDEX);

        return expression.split(customDelimiter);
    }

    private void validate(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException("There are no tokens in expression");
        }
    }

    public boolean isCustomExpression(String inputString) {
        return CUSTOM_EXPRESSION_PATTERN.matcher(inputString)
                .matches();
    }
}
