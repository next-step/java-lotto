package study.step1;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final String DEFALUT_EXPRESSION = "0";
    private static final int INDEX_ONE = 1;
    private static final int INDEX_TWO = 2;
    private static final String DELIMITER = ",|:";
    private static final Pattern PATTERN = Pattern.compile("//(.)\\n(.*)");

    private final String expression;

    public Expression(String expression) {
        this.expression = validateExpression(expression);
    }

    private String validateExpression(String expression) {
        if (isStringNullCheck(expression)){
            return DEFALUT_EXPRESSION;
        }
        return expression;
    }

    private static boolean isStringNullCheck(String input) {
        if (Objects.isNull(input) || input.isEmpty()){
            return true;
        }
        return false;
    }

    public String[] split() {
        Matcher m = PATTERN.matcher(expression);
        if (m.find()){
            String customDelimiter = m.group(INDEX_ONE);
            return m.group(INDEX_TWO).split(customDelimiter);
        }
        return expression.split(DELIMITER);
    }
}
