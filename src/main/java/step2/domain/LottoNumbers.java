package step2.domain;

import java.util.List;
import java.util.Objects;

class LottoNumbers {
    private static final int COUNT = 6;

    private final List<Integer> numbers;

    LottoNumbers(final List<Integer> numbers) {
        check(numbers);
        this.numbers = numbers;
    }

    private void check(final List<Integer> numbers) {
        if (numbers.size() != COUNT) {
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
}
