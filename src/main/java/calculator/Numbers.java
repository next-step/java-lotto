package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(String[] numberArray) {
        List<Number> numbers = Arrays.stream(numberArray)
                                    .map(Number::new)
                                    .collect(collectingAndThen(toList(), Collections::unmodifiableList));

        return new Numbers(numbers);
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(Number::getNumber)
                .collect(Collectors.toList());
    }
}
