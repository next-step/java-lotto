package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final int ZERO = 0;
    private static final String DELIMITER = ",|:";
    private static final List<Integer> BLANK_LIST = new ArrayList<>();
    private static final String NEGATIVE_EXCEPTION = "[ERROR] 음수가 포함될 수 없습니다.";
    private static final String NOT_A_NUMBER_EXCEPTION = "[ERROR] 숫자와 구분자만 입력할 수 있습니다.";

    private final List<Integer> userNumbers;

    private StringCalculator(List<Integer> userNumbers) {
        checkNegativeValue(userNumbers);
        this.userNumbers = userNumbers;
    }

    public static StringCalculator of(String userInput) {
        List<Integer> userNumbers = parseTextToInt(userInput);
        return new StringCalculator(userNumbers);
    }

    public int sumNumbers() {
        return userNumbers.stream().reduce(0, Integer::sum);
    }

    private void checkNegativeValue(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < ZERO) {
                throw new RuntimeException(NEGATIVE_EXCEPTION);
            }
        }
    }

    private static boolean isBlank(String userInput) {
        return Objects.isNull(userInput) || userInput.trim().isEmpty();
    }

    private static int convertNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_EXCEPTION);
        }
    }

    private static List<Integer> parseTextToInt(String userInput) {
        if (isBlank(userInput)) {
            return BLANK_LIST;
        }

        String[] numbers = splitText(userInput);
        return Arrays.stream(numbers)
            .map(StringCalculator::convertNumber)
            .collect(Collectors.toList());
    }

    private static String[] splitText(String userInput) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(userInput);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter + '|' + DELIMITER);
        }
        return userInput.split(DELIMITER);
    }


}
