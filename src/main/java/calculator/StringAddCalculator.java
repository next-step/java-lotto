package calculator;

import calculator.domain.InputNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern PATTERN_CUSTOM_SEPARATOR = Pattern.compile("//(.)\n(.*)");

    private static final int DEFAULT_SUM_NUMBER = 0;
    private static final String SEPARATOR = ",|:";

    public static int splitAndSum(String input) {
        if (!validationCheck(input)) {
            return DEFAULT_SUM_NUMBER;
        }

        return addNumbers(splitText(input));
    }

    private static int addNumbers(String[] splitedNumberText) {
        InputNumber sum = InputNumber.create(DEFAULT_SUM_NUMBER);

        for (String numberText : splitedNumberText) {
            sum.add(InputNumber.create(Integer.parseInt(numberText)));
        }

        return sum.getNumber();
    }

    private static String[] splitText(String input) {
        Matcher m = PATTERN_CUSTOM_SEPARATOR.matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return input.split(SEPARATOR);
    }

    private static boolean validationCheck(String input) {
        if (input == null) {
            return false;
        }

        return !input.isEmpty();
    }
}
