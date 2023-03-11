package pluscalculator.domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {
    private static Double DEFAULT_VALUE = 0.0;
    private static Pattern NUMBER_PATTERN = Pattern.compile("[(0-9|.)]+");

    private final List<Double> numbers;

    public Numbers() {
        numbers = List.of(DEFAULT_VALUE);
    }

    public Numbers(List<String> numbers) {
        validateOnlyNumber(numbers);
        this.numbers = numbers.stream().map(Double::parseDouble).collect(Collectors.toList());
    }

    private void validateOnlyNumber(List<String> numbers) {
        if (numbers.stream().anyMatch(number -> !NUMBER_PATTERN.matcher(number).matches())) {
            throw new RuntimeException();
        }
    }

    public double plusAll() {
        return numbers.stream().reduce(0.0, Double::sum);
    }
}