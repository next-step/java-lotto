package adder;

import common.StringResources;

import java.util.Arrays;

public class StringAdder {

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

        StringBuilder separator = new StringBuilder(StringResources.DEFAULT_SEPARATOR);

        if (numberStr.startsWith(StringResources.CUSTOM_SEPARATOR_STARTER)) {
            separator.append(numberStr, 2, numberStr.indexOf(StringResources.LINE_FEED));
        }

        return separator.append(StringResources.BRACKET_CLOSER)
                .toString();
    }

    private static String[] split(String numberStr, String separator) {
        if (numberStr.startsWith(StringResources.CUSTOM_SEPARATOR_STARTER)) {
            numberStr = numberStr.substring(numberStr.indexOf(StringResources.LINE_FEED) + 1);
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
