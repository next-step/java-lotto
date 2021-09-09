package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAdditionCalculator {
    private static final int DEFAULT_VALUE = 0;
    private static final int MINIMUM_INPUT_VALUE = 0;
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String NUMBER_EXCEPTION_MESSAGE = "숫자 이외의 값 또는 음수인 경우는 없습니다.";


    public int splitAndSum(String input) {
        return add(splitAndReturnNumberList(input));
    }

    private int add(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<Integer> splitAndReturnNumberList(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.singletonList(DEFAULT_VALUE);
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return stringArrayToNumberList(matcher.group(2).split(customDelimiter));
        }

        return stringArrayToNumberList(input.split(DELIMITER));
    }

    private List<Integer> stringArrayToNumberList(String[] input) {
        return Arrays.stream(input)
                .filter(this::vaild)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean vaild(String input) {
        if (Integer.parseInt(input) < MINIMUM_INPUT_VALUE) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION_MESSAGE);
        }
        return true;
    }

}
