package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String SEPARATOR = ",|:";

    public static int splitAndSum(String text) {
        if (checkEmptyValue(text)) {
            return 0;
        }
        String[] numbers = stringToArray(text);
        return Arrays.stream(numbers)
                .map(StringAddCalculator::stringToInt)
                .reduce(0, Integer::sum);
    }

    private static int stringToInt(String text) {
        int number = Integer.parseInt(text);
        isNegativeNumber(number);
        return number;
    }

    private static boolean checkEmptyValue(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] stringToArray(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return text.split(SEPARATOR);
    }

    private static void isNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수가 존재합니다.");
        }
    }
}
