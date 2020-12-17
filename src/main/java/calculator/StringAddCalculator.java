package calculator;



import calculator.util.NumberUtil;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final static String CUSTOM_PATTERN = "\"//(.)\\n(.*)\"";
    public static int splitAndSum(String expression) {
        if(isEmpty(expression)) {
            return 0;
        };
        String[] splitNumbers = splitExpression(expression);
        int result = sumNumbers(splitNumbers);
        return result;
    }

    private static int sumNumbers( String[] texts) {
        int result = 0;
        for ( int i = 0; i < texts.length; i++) {
            String numberOfExpression = texts[i];
            result = result + NumberUtil.stringToInt(numberOfExpression);
        }
        return result;
    }

    private static String[] splitExpression(String expression) {

        Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        return expression.split(",|:");
    }

    private static boolean isEmpty(String expression) {
        return Objects.isNull(expression) || expression.isEmpty();
    }
}
