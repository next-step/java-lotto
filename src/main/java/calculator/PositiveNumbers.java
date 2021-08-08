package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {
    private final List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(int[] positiveNumbers) {
        this.positiveNumbers = Arrays.stream(positiveNumbers)
                .mapToObj(PositiveNumber::new)
                .collect(Collectors.toList());
    }

    public int sum() {
        return positiveNumbers.stream()
            .mapToInt(PositiveNumber::number)
            .reduce(0, Integer::sum);
    }
}
