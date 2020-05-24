package study.step1;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final String DEFALUT_EXPRESSION = "0";
    private static final int DELIMITER_LOCATION_NUMBER = 1;
    private static final int NUMBERPARTS_LOCATION_NUMBER = 2;
    private static final String DELIMITER = ",|:";
    private static final Pattern PATTERN = Pattern.compile("//(.)\\n(.*)");

    public static String validateExpression(String expression) {
        if (isStringNullCheck(expression)){
            return DEFALUT_EXPRESSION;
        }
        return expression;
    }

    private static boolean isStringNullCheck(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }

    public static String[] split(String expression) {
        Matcher m = PATTERN.matcher(expression);
        if (m.find()){
            String customDelimiter = m.group(DELIMITER_LOCATION_NUMBER);
            return m.group(NUMBERPARTS_LOCATION_NUMBER).split(customDelimiter);
        }
        return expression.split(DELIMITER);
    }
}
