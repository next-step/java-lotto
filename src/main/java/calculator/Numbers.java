package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Numbers {

    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(String[] numberArray) {
        List<Integer> numbers = Arrays.stream(numberArray)
                                    .map(Integer::parseInt)
                                    .collect(collectingAndThen(toList(), Collections::unmodifiableList));

        return new Numbers(numbers);
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(number -> number)
                .sum();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
