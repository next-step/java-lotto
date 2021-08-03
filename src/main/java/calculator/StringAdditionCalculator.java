package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {
    private static final String NOT_VALID_ARGUMENT_EXIST_STATEMENT = "음수 또는 숫자이외 값이 존재합니다";

    public String[] splitWithCommaOrColon(String expression) {
        return expression.split(",|:");
    }

    public String[] splitWithCustomDelimiter(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        return splitWithCommaOrColon(expression);
    }

}
