package step1.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Numbers {
    List<Number> numbers;

    public Numbers(List<Number> number) {
        this.numbers = number;
    }

    public List<Number> getList() {
        return Collections.unmodifiableList(numbers);
    }

    public Number sum() {
        return new Number(numbers.stream()
                .mapToInt(Number::getNumber)
                .sum()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers that = (Numbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
