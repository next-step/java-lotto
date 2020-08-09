package adder;

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

        StringBuilder separator = new StringBuilder("[,:");

        if (numberStr.startsWith("//")) {
            separator.append(numberStr, 2, numberStr.indexOf("\n"));
        }

        return separator.append("]")
                .toString();
    }

    private static String[] split(String numberStr, String separator) {
        if (numberStr.startsWith("//")) {
            numberStr = numberStr.substring(numberStr.indexOf("\n") + 1);
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
            if (num < 0) {
                throw new RuntimeException("음수를 넣지 마세요");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자만 넣어주세요.");
        }
    }
}
