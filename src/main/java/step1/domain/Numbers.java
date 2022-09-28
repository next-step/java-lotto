package step1.domain;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;

public class Numbers {

    private final ArrayDeque<Number> numbers;

    public Numbers(ArrayDeque<Number> numbers) {
        this.numbers = new ArrayDeque<>(numbers);
    }

    public Numbers(List<Number> numberList) {
        this(new ArrayDeque<>(numberList));
    }

    public Number pollNumber() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("더 이상 숫자가 존재하지 않습니다.");
        }
        return numbers.poll();
    }

    public int size() {
        return numbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
