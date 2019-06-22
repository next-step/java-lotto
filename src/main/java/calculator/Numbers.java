package calculator;

import java.util.Arrays;
import java.util.List;

import static calculator.Number.DEFAULT;
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
        return numbers.stream().reduce(new Number(DEFAULT), Number::add).getNumber();
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
