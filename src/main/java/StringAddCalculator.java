import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringAddCalculator {

    private static final int EMPTY_NUM = 0;
    private static final String COMMA_OR_COLON_DELIMITER = ",|:";
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";

    public static int calculator(String input) {
        if (input == null || input.isEmpty()) {
            return EMPTY_NUM;
        }

        if (checkOneNumber(input)) {
            return Integer.parseInt(input);
        }

        return splitAndSum(input);
    }

    private static boolean checkOneNumber(String input) {
        String[] numbers = input.split("");
        int size = numbers.length;
        return size == 1;
    }

    private static int splitAndSum(String input) {
        String[] numbers = input.split(COMMA_OR_COLON_DELIMITER);

        return sum(numbers);
    }

    private static int splitRegexAndSum(String input) {
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(input);
        int sum = 0;
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return sum(tokens);
        }
        return sum;
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        int size = numbers.length;
        for (String aNumber : numbers) {
            sum += Integer.parseInt(aNumber);
        }
        return sum;
    }

}
