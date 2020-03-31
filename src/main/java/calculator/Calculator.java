package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public String[] split(String text) {
        String delimiter = ",|:";
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(text);

        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            text = matcher.group(2);
            delimiter = delimiter + "|" + customDelimiter;
        }

        return text.split(delimiter);
    }

    public double sum(String text) {
        if (text == null || "".equals(text.trim())) {
            return 0;
        }

        return Arrays.stream(split(text))
                .mapToDouble(this::parseDouble)
                .sum();
    }

    private double parseDouble(String token) {
        double number = Double.parseDouble(token);
        if(number < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
        return number;
    }
}
