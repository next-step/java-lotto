package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public final static int MAX_NUMBER_LENGTH = 6;

    private final List<Number> numbers;

    public Lotto(final String values) {
        this(Arrays.stream(values.split(","))
                .map(Number::new)
                .collect(Collectors.toList()));
    }

    public Lotto(final List<Number> numbers) {
        validation(numbers);
        this.numbers = numbers;
        sort();
    }

    public void validation(final List<Number> numbers) {
        if (new HashSet<>(numbers).size() != MAX_NUMBER_LENGTH)
            throw new IllegalArgumentException("로또 번호는 6개의 숫자여야 합니다.");
    }

    private void sort() {
        Collections.sort(numbers);
    }

    public List<Number> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Number::value)
                .collect(Collectors.toList())
                .toString();
    }
}
