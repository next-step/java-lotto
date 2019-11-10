package step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

class LottoNumbers {
    private static final int COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    LottoNumbers(final List<Integer> numbers) {
        checkNumberCount(numbers);
        checkNumberRange(numbers);
        this.numbers = numbers;
    }

    private void checkNumberCount(final List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberRange(final List<Integer> numbers) {
        numbers.forEach(this::checkNumberRange);
    }

    private void checkNumberRange(final Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumbers)) return false;
        final LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]"));
    }
}
