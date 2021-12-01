package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Number> numbers;
    private int sum = 0;

    public Numbers(String[] numbers) {
        this(Arrays.stream(numbers).map(Number::new).collect(Collectors.toList()));
    }

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        for (Number number : numbers) {
            sum += number.getValue();
        }

        return sum;
    }
}
