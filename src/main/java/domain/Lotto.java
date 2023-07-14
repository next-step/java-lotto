package domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class Lotto {

    static final int REQUIRED_LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(final List<Integer> numbers) {
        validateLottoNumberCount(numbers);

        this.lottoNumbers = toLottoNumbers(numbers);
    }

    private static void validateLottoNumberCount(final List<Integer> numbers) {
        if (numbers.size() != REQUIRED_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private static Set<LottoNumber> toLottoNumbers(final List<Integer> origin) {
        Set<LottoNumber> lottoNumbers = origin.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());

        if (origin.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        return lottoNumbers;
    }

    public long countMatchLottoNumber(final Lotto target) {
        return this.lottoNumbers.stream()
                .filter(target::containsLottoNumber)
                .count();
    }

    public boolean containsLottoNumber(final LottoNumber bonus) {
        return lottoNumbers.contains(bonus);
    }

    public Set<LottoNumber> getLottoNumbers() {
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
