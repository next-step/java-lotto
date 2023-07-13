package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Lotto {

    public static final int SIZE = 6;
    public static final int COST = 1_000;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(final List<Integer> numbers) {
        validateSize(numbers);
        validateDistinction(numbers);

        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableList());
    }

    public static Lotto create(final List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("로또는 6개의 번호를 가져야합니다. 현재 번호 개수: " + numbers.size());
        }
    }

    private void validateDistinction(final List<Integer> numbers) {
        if (distinctSize(numbers) != SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public int checkMatchCount(final Lotto other) {
        final List<LottoNumber> copyLottoNumbers = new ArrayList<>(lottoNumbers);
        copyLottoNumbers.retainAll(other.lottoNumbers);
        return copyLottoNumbers.size();
    }

    public boolean contains(final LottoNumber bonusBall) {
        return lottoNumbers.contains(bonusBall);
    }

    private static long distinctSize(final List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
