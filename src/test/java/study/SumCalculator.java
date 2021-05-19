package study;

import java.util.List;
import java.util.stream.Collectors;

public class SumCalculator {
    private final String input;

    public SumCalculator(String input) {
        this.input = input;
    }

    public boolean isUnusable() {
        return isNull() || isEmpty();
    }

    private boolean isEmpty() {
        return input.isEmpty();
    }

    private boolean isNull() {
        return input == null;
    }

    public int sum() {
        return stringToInts(input).stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<Integer> stringToInts(String input) {
        return Splitter.split(input)
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
