package kr.insup.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern pattern = Pattern.compile("^//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = "[:,]";

    public int calculate(String input) {
        String delimiter = getDelimiter(input);
        String onlyNumbers = getOnlyNumbers(input);
        String[] numbers = onlyNumbers.split(delimiter);

        return calculateNumbers(numbers);
    }

    private int calculateNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += stringToIntConverter(number);
        }
        return sum;
    }

    private int stringToIntConverter(String number) {
        if (number == null || number.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(number);
    }

    public String getDelimiter(String input) {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            String delimiter = m.group(1);
            return escapeCharacter(delimiter);
        }
        return DEFAULT_DELIMITER;
    }

    public String getOnlyNumbers(String input) {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            return m.group(2);
        }
        return input;
    }

    private String escapeCharacter(String delimiter) {
        if ("\\[](){}*+?|^$.".contains(delimiter)) {
            return "\\" + delimiter;
        }
        return delimiter;
    }
}
