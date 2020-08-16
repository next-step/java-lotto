import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class ExpressionValidator {
    private static final String EXPRESSION_PATTERN = "(//(.)\\n)*(([0-9])(.[0-9])*)";
    private static final String EXPRESSION_PATTERN_WITH_CUSTOM_DELIMITER = "^([\\/]{2}.\n).*$";
    private static final String NUMBER_PATTERN = "^[0-9]$";

    public static boolean validExpression(String expressionValue) {
        if (StringUtils.isBlank(expressionValue)) {
            return false;
        }

        return Pattern.matches(EXPRESSION_PATTERN, expressionValue);
    }

    public static boolean isCustomDelimiterExist(String expression) {
        return Pattern.matches(EXPRESSION_PATTERN_WITH_CUSTOM_DELIMITER, expression);
    }

    public static boolean validNumber(String number) {
        if (!Pattern.matches(NUMBER_PATTERN, number)) {
            return false;
        }

        return Integer.parseInt(number) >= 0;
    }
}
