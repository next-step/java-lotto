package lottos.domain.numbers;

import lottos.domain.exceptions.LottoSizeIncorrectException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {

    private static final int COUNT_OF_LOTTO = 6;

    private final List<Number> numbers;

    private Numbers(final List<Integer> numbers) {
        checkNumberCount(numbers);
        this.numbers = numbers.stream()
                .map(Number::valueOf)
                .collect(Collectors.toList());
    }

    public static Numbers valueOf(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    private void checkNumberCount(final List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO) {
            throw new LottoSizeIncorrectException();
        }
    }

    public List<Number> elements() {
        return Collections.unmodifiableList(this.numbers);
    }

    public int match(Numbers matchNumbers) {
        return (int) (matchNumbers.numbers.stream()
                .filter(this.numbers::contains)
                .count());
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
