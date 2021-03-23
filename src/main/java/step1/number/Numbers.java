package step1.number;

import java.util.List;
import java.util.Objects;

public final class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        if (isNull(numbers)) {
            throw new IllegalArgumentException("null 값을 입력했습니다.");
        }
        this.numbers = numbers;
    }

    private final boolean isNull(List<Number> numbers) {
        return numbers == null;
    }

    public final int sum() {
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
