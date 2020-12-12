package calculator.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(String[] texts) {
        this.numbers = textToInt(texts);
    }

    private List<Number> textToInt(String[] texts) {
        return Stream.of(texts)
                .map(text -> Number.of(text))
                .collect(Collectors.toList());
    }

    public int sum() {
        return numbers.stream()
                .reduce(Number.zero(), Number::plus)
                .getValue();
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
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
