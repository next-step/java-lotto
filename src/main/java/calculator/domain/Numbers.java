package calculator.domain;

import calculator.utils.StringUtils;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Numbers {
    private final List<Number> numbers;

    private Numbers(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(final List<String> values) {
        return values.stream()
                .filter(StringUtils::isNumber)
                .map(value -> Number.from(Integer.parseInt(value)))
                .collect(collectingAndThen(toList(),
                        Numbers::new));
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
