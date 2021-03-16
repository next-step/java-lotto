package StringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(String[] values) {
        numbers = Arrays.stream(values)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::getValue)
                .sum();
    }
}
