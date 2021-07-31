package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final String NORMAL_REGEX = ",|:";
    private static final String PREFIX_CUSTOM_DELIMITER = "//";
    private static final String SUFFIX_CUSTOM_DELIMITER = "\\n";

    public static int calculate(String input) {
        if ("".equals(input) || input == null) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        String[] numbers = getNumbers(input);

        negativeNumberCheck(numbers);

        return sum(numbers);
    }

    private static void negativeNumberCheck(String[] numbers) {
        List<Integer> result = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .filter(number -> number < 0)
                .collect(Collectors.toList());

        if (!result.isEmpty()) {
            throw new RuntimeException();
        }
    }

    private static int sum(String[] numbers) {
        int result;
        result = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
        return result;
    }

    private static String[] getNumbers(String input) {
        if (isCustomDelimiter(input)) {
            return getSplitNumbersByCustomDelimiter(input);
        }
        return splitNumbersByNormalDelimiter(input);
    }

    private static boolean isCustomDelimiter(String input) {
        return input.contains(PREFIX_CUSTOM_DELIMITER) && input.contains(SUFFIX_CUSTOM_DELIMITER);
    }

    private static String[] getSplitNumbersByCustomDelimiter(String input) {
        String prefix = input.substring(0, 5);
        String suffix = input.substring(5, input.length());

        String slashRemoveString = prefix.replace(PREFIX_CUSTOM_DELIMITER, "");
        String delimiter = slashRemoveString.replace(SUFFIX_CUSTOM_DELIMITER, "");

        return suffix.split(delimiter);
    }

    private static String[] splitNumbersByNormalDelimiter(String input) {
        return input.split(NORMAL_REGEX);
    }
}
