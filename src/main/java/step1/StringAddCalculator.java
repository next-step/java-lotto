package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final String MATCHER_DELIMITER = "1";
    private static final String MATCHER_EXPRESSION = "2";

    private String expression;
    private String delimiter;

    public StringAddCalculator(String expression) {
        this.expression = validExpression(expression);
    }

    private String validExpression(String expression) {
        if(expression.isEmpty() || expression == null) {
            return "0";
        }
        return expression;
    }

    private int toInt(String expression) {
        try {
            int toInt = Integer.parseInt(expression);
            if(toInt < 0) {
                throw new IllegalArgumentException("음수는 처리할 수 없습니다.");
            }
            return toInt;
        }catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public int startAddCalculation() {
        delimiter = getDelimiter();
        String[] expressionToArray = getExpressionToArray(delimiter);
        return getAddResult(expressionToArray);
    }

    private String getDelimiter() {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        if(matcher.find()) {
            this.expression = matcher.group(MATCHER_EXPRESSION);
            return matcher.group(MATCHER_DELIMITER);
        }
        return "[/,:/g]";
    }

    private String[] getExpressionToArray(String delimiter) {
        return expression.split(delimiter);
    }

    private int getAddResult(String[] expressionToArray) {
        return Arrays.stream(expressionToArray)
                .mapToInt(stringNumber -> toInt(stringNumber))
                .sum();

    }
}
