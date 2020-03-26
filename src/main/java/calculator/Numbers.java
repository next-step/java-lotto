package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {
    private List<Number> numbers;

    public Numbers(final String[] splitedString) {
        final List<Number> numbers = new ArrayList<>();
        for (final String letter : splitedString) {
            numbers.add(Number.valueOf(letter));
        }
        this.numbers = numbers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
