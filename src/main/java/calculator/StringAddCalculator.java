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

        return addNumbers(input);
    }

    private static int addNumbers(String input) {
        InputNumber sum = InputNumber.create(DEFAULT_SUM_NUMBER);

        String[] splitedText = splitText(input);

        for (String text : splitedText) {
            sum.add(InputNumber.create(Integer.parseInt(text)));
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

        if (input.isEmpty()) {
            return false;
        }
        return true;
    }


}
