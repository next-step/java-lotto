package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern DELIMITER = Pattern.compile("//(.)\\\\n(.*)");

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
        Matcher matcher = DELIMITER.matcher(expression);
        if(matcher.find()) {
            this.expression = matcher.group(2);
            return matcher.group(1);
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
