package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers = (Numbers) o;
        return Objects.equals(this.numbers, numbers.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
