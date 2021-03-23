package step1.calculator;

import step1.number.Number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static utils.StringUtils.isNullOrBlank;
import static utils.StringUtils.splitByCommaAndColon;

public final class StringAddCalculator {

    public static final int splitAndSum(String expression) {
        if (isNullOrBlank(expression)) {
            return 0;
        }
        List<Number> numbers = convertStringArrayToNumberList(splitByCommaAndColon(expression));
        return sum(numbers);
    }

    private static final List<Number> convertStringArrayToNumberList(String[] data) {
        return Arrays.stream(data)
                .mapToInt(Integer::parseInt)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }

    private static final int sum(List<Number> numbers) {
        return numbers.stream().mapToInt(Number::getNumber).sum();
    }
}
