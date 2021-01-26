package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int calculate(final String inputText) {
        if (inputText == null) {
            return 0;
        }
        if ("".equals(inputText)) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return sumNumbers(tokens);
        }
        String[] tokens = inputText.split(",|:");
        if (tokens.length > 0) {
            return sumNumbers(tokens);
        }
        return Integer.parseInt(inputText);
    }

    private int sumNumbers(final String[] tokens) {
        int sum = 0;
        for (final String token : tokens) {
            int number = Integer.parseInt(token);
            minusNumberThrowsException(number);
            sum += number;
        }
        return sum;
    }

    private void minusNumberThrowsException(final int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }
    }
}
