package step2.domain;

import java.util.List;
import java.util.Objects;

class LottoNumbers {
    private final List<Integer> numbers;

    LottoNumbers(final List<Integer> numbers) {
        this.numbers = numbers;
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
