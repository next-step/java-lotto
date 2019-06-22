package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static calculator.Number.ZERO;
import static java.util.stream.Collectors.toList;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(String[] numbersOfString) {
        List<Number> numbers = Arrays.stream(numbersOfString)
                .map(Number::of)
                .collect(toList());
        return new Numbers(numbers);
    }

    public int sum() {
        return numbers.stream()
                .reduce(ZERO, Number::add)
                .getNumber();
    }

    List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
