package lotto.model;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int COUNT = 6;

    /**
     * 항상 정렬된 상태임을 보장한다.
     */
    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers.stream()
                .sorted()
                .map(Number::new)
                .collect(toUnmodifiableList());
    }

    public static Lotto of(Integer... numbers) {
        return new Lotto(List.of(numbers));
    }

    private void validate(List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException("lotto numbers are not " + COUNT);
        }

        long distinct = numbers.stream().distinct().count();
        if (distinct != COUNT) {
            throw new IllegalArgumentException("lotto numbers must be distinct: " + numbers);
        }
    }

    public List<Number> numbers() {
        return this.numbers;
    }

    public int matches(Lotto other) {
        List<Number> matches = this.numbers.stream()
                .filter(other.numbers::contains)
                .collect(toList());
        return matches.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
