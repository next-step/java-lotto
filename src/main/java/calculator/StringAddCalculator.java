package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isEmpty(text))
            return 0;

        return sum(getNumbers(text));
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(String[] numbers) {
        if (numbers.length == 1)
            return convertStringToInt(numbers[0]);

        return Arrays.stream(numbers)
                .map(number -> convertStringToInt(number))
                .reduce(0, Integer::sum);
    }

    private static String[] getNumbers(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(DELIMITER);
    }

    private static int convertStringToInt(String number) {
        if (Integer.parseInt(number) < 0 || isNumeric(number))
            throw new RuntimeException();

        return Integer.parseInt(number);
    }

    private static boolean isNumeric(String number) {
        return number.matches("^[0-9]+$");
    }
}
