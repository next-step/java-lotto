package step1.domain;

import step1.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    private Numbers(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(final List<String> inputs) {
        List<Number> numbers = new ArrayList<>();
        for (String input : inputs) {
            validate(input);
            numbers.add(Number.from(Integer.parseInt(input)));
        }
        return new Numbers(numbers);
    }

    private static void validate(final String input) {
        if (!StringUtils.isNumber(input)) {
            throw new RuntimeException("Only numbers are available");
        }
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }
}
