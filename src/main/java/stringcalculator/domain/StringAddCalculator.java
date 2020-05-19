package stringcalculator.domain;

import stringcalculator.domain.vo.Number;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final int DEFAULT_NUMBER = 0;

    public static int calculate(String expression) {
        if (isNullOrEmpty(expression)) {
            return DEFAULT_NUMBER;
        }

        List<String> splits = Splitter.split(expression);

        List<Number> numbers = splits.stream()
                .map(Number::stringToNumber)
                .collect(Collectors.toList());

        Number result = numbers.stream()
                .reduce(Number::sum)
                .orElseThrow(() -> new IllegalStateException("계산할 값이 존재하지않습니다."));

        return result.getValue();
    }

    private static boolean isNullOrEmpty(String expression) {
        return Objects.isNull(expression) || expression.isEmpty();
    }
}
