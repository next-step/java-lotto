package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private String expression;
    private String delimiter;
    private int result;

    public StringAddCalculator(String expression) {
        validExpression(expression);
        this.expression = expression;
    }

    private void validExpression(String expression) {
        switch (expression.length()) {
            case 0: this.result = 0; break;
            case 1: this.result = toInt(expression); break;
            default: return;
        }
    }

    private int toInt(String expression) {
        try {
            return Integer.parseInt(expression);
        }catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public int getResult() {
        return result;
    }

    public void startAddCalculation() {
        delimiter = getDelimiter();
        String[] expressionToArray = getExpressionToArray(delimiter);
        result = getAddResult(expressionToArray);
    }

    private String getDelimiter() {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(expression);
        String delimiter = "[/,:/g]";
        if(matcher.find()) {
            this.expression = matcher.group(2);
            return matcher.group(1);
        }
        return delimiter;
    }

    private String[] getExpressionToArray(String delimiter) {
        return expression.split(delimiter);
    }

    private int getAddResult(String[] expressionToArray) {
        return Arrays.stream(expressionToArray)
                .mapToInt(Integer::parseInt)
                .sum();

    }
}
