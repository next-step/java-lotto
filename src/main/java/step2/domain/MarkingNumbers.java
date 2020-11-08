package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class MarkingNumbers {
    public static final String DELIMITER = ", ";

    private final List<Integer> markingNumbers;

    public MarkingNumbers(List<Integer> markingNumbers) {
        this.markingNumbers = markingNumbers;
    }

    @Override
    public String toString() {
        String result = markingNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
        return String.format("[%s]", result);
    }

    public boolean contains(Integer number) {
        return markingNumbers.contains(number);
    }
}
