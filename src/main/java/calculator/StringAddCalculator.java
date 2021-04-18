package calculator;

import calculator.NotValidCalculatorValue;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {

        if (text == null || text.isEmpty()) {
            return 0;
        }

        if ( text.length() == 1) {
            int number = Integer.parseInt(text);
            validCheck(number);
            return number;
        }

        String[] tokens = ifCustomDelimiter(text);

        if (isNotCustomDelimiter(tokens)) {
            tokens = text.split(",|:");
        }

        return getSum(tokens);
    }

    private static boolean isNotCustomDelimiter(String[] tokens) {
        return tokens == null;
    }

    private static String[] ifCustomDelimiter(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2)
                    .split(customDelimiter);
        }
        return null;
    }

    private static int getSum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .map(num -> {
                    if (num < 0)
                        throw new NotValidCalculatorValue("음수는 취급하지 않습니다.");
                    return num;
                })
                .sum();
    }

    private static void validCheck(Integer number){
        if (number < 0) {
            throw new NotValidCalculatorValue("음수는 취급하지 않습니다.");
        }
    }
}
