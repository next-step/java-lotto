package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String DELIMITER = ",|:";
    private static final int DEFAULT_VALUE = 0;
    private static final String NEGATIVE_EXCEPTION = "[ERROR] 음수가 포함될 수 없습니다.";

    private final List<Integer> userNumbers;

    private StringCalculator(List<Integer> userNumbers) {
        checkNegativeValue(userNumbers);
        this.userNumbers = userNumbers;
    }

    public static StringCalculator of(String userInput) {
        List<Integer> userNumbers = parseTextToInt(userInput);
        return new StringCalculator(userNumbers);
    }

    private static boolean isBlank(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

    private static void hasNegativeValue(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new RuntimeException(NEGATIVE_EXCEPTION);
            }
        }
    }

    private static List<Integer> parseTextToInt(String text) {
        String[] numbers= splitText(text);

        return Arrays.stream(numbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static String[] splitText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter + '|' + DELIMITER);
            return tokens;
        }
        return text.split(DELIMITER);
    }

    private static int sumNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
