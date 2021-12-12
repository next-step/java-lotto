package lotto.domain;

import java.util.List;
import java.util.Objects;

public class NumberGroup {
    public static final int LIMIT = 6;
    private final List<Number> numbers;

    public NumberGroup(List<Number> numbers) {
        this.numbers = numbers;
    }

    public boolean appropriate(int count) {
        return numbers.size() == count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberGroup)) return false;
        NumberGroup that = (NumberGroup) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "NumberGroup{" +
                "numbers=" + numbers.toString() +
                '}';
    }
}
