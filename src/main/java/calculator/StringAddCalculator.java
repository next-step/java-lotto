package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final String[] DELIMITERS = {",", ":"};
    private static final String DELIMITERS_REGEX = String.join("|", DELIMITERS);

    private static final String CUSTOM_DELIMITER_INPUT_REGEX = "//(.)\n(.*)";
    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int NUMBERS_GROUP_INDEX = 2;

    private static final Pattern INPUT_PATTERN = Pattern.compile(CUSTOM_DELIMITER_INPUT_REGEX);

    public static Number calculate(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return Number.ZERO_NUMBER;
        }

        return splitInput(input).sum();
    }

    private static Numbers splitInput(String input) {
        Matcher matcher = INPUT_PATTERN.matcher(input);

        if (matcher.find()) {
            String delimiter = matcher.group(DELIMITER_GROUP_INDEX);

            String[] numberStrings = matcher.group(NUMBERS_GROUP_INDEX).split(delimiter);
            return parseNumbers(numberStrings);
        }

        String[] numberStrings = input.split(DELIMITERS_REGEX);
        return parseNumbers(numberStrings);
    }

    private static Numbers parseNumbers(String[] numberStrings) {
        List<Number> numbers = Arrays.stream(numberStrings)
                .map(Number::new)
                .collect(Collectors.toList());

        numbers.forEach(StringAddCalculator::checkNumber);

        return new Numbers(numbers);
    }

    private static void checkNumber(Number number) {
        if (number.isNegative()) {
            throw new RuntimeException("양수만 입력할 수 있습니다.");
        }
    }

}
