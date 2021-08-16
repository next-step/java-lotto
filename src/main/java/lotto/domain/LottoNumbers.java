package lotto.domain;

import lotto.exception.InputError;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    private static final int LOTTO_LENGTH = 6;
    private final List<Integer> numbers;

    public LottoNumbers(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new InputError("로또는 6개의 숫자여야 합니다.");
        }
        this.numbers = numbers;
    }

    public int countSameNumber(final LottoNumbers otherLottoNumbers) {
        return (int) otherLottoNumbers.value().stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Integer> value() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
