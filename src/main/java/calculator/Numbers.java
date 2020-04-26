package calculator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public static Numbers create(List<Integer> numbers) {
        List<Number> collect = numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
        return new Numbers(collect);
    }

    public int sum() {
        Number result = Number.ZERO;
        for (Number number : numbers) {
            result = number.add(result);
        }
        return result.getNumber();
    }

}
