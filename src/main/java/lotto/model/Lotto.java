package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<Integer> numbers) {
        validateSize(numbers);
        validateDistinction(numbers);

        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 번호를 가져야합니다.");
        }
    }

    private void validateDistinction(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public int checkMatchCount(final Lotto winningNumbers) {
        return Math.toIntExact(lottoNumbers.stream()
                .filter(winningNumbers::hasNumber)
                .count());
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(this.lottoNumbers);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
