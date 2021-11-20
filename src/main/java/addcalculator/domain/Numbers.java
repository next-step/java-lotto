package addcalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static Numbers of(List<Number> numbers) {
        return new Numbers(numbers);
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::getValue)
                .sum();
    }
}
