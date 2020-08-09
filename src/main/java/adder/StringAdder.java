package adder;

import common.StringResources;

import java.util.Arrays;

public class StringAdder {

    public static final String LINE_FEED = "\n";
    public static final String CUSTOM_SEPARATOR_STARTER = "//";
    public static final String DEFAULT_SEPARATOR = "[,:";
    public static final String SEPARATOR_CLOSER = "]";

    public static int splitAndSum(String numberStr) {

        if (isEmptyNumbers(numberStr)) {
            return 0;
        }

        return sum(split(numberStr, makeSeparator(numberStr)));
    }

    private static boolean isEmptyNumbers(String numbers) {
        return numbers == null || numbers.isEmpty();
    }

    private static String makeSeparator(String numberStr) {

        StringBuilder separator = new StringBuilder(DEFAULT_SEPARATOR);

        if (numberStr.startsWith(CUSTOM_SEPARATOR_STARTER)) {
            separator.append(numberStr, 2, numberStr.indexOf(LINE_FEED));
        }

        return separator.append(SEPARATOR_CLOSER)
                .toString();
    }

    private static String[] split(String numberStr, String separator) {
        if (numberStr.startsWith(CUSTOM_SEPARATOR_STARTER)) {
            numberStr = numberStr.substring(numberStr.indexOf(LINE_FEED) + 1);
        }
        return numberStr.split(separator);
    }

    private static int sum(String[] numbers) {

        return Arrays.stream(numbers)
                .mapToInt(StringAdder::toInt)
                .sum();
    }

    private static int toInt(String number) {
        try {
            int num = Integer.parseInt(number);
            verifyNegative(num);
            return num;
        } catch (NumberFormatException e) {
            throw new RuntimeException(StringResources.ERR_ONLY_NUMBER);
        }
    }

    private static void verifyNegative(int num) {
        if (num < 0) {
            throw new RuntimeException(StringResources.ERR_NO_NEGATIVE);
        }
    }
}
