package calculation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Number> number;

    public Numbers(String[] numbers) {
        this(changeToIntegerArrayType(numbers));
    }

    public Numbers(List<Number> numbers) {
        this.number = Collections.unmodifiableList(numbers);
    }

    private static List<Number> changeToIntegerArrayType(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public int sum() {
        return number.stream()
                .mapToInt(number -> number.value())
                .sum();
    }
}
