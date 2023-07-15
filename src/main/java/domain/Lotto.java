package domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    static final int REQUIRED_LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(final List<Integer> numbers) {
        validateSize(numbers);
        final Set<LottoNumber> lottoNumbers = toLottoNumbers(numbers);
        validateUniqueNumbers(numbers, lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public long countMatchLottoNumber(final Lotto target) {
        return this.lottoNumbers.stream()
            .filter(target::containsLottoNumber)
            .count();
    }

    public boolean containsLottoNumber(final LottoNumber bonus) {
        return lottoNumbers.contains(bonus);
    }

    public String format(final LottoFormatter formatter) {
        return formatter.format(lottoNumbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != REQUIRED_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private Set<LottoNumber> toLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toUnmodifiableSet());
    }

    private void validateUniqueNumbers(List<Integer> numbers, Set<LottoNumber> lottoNumbers) {
        if (numbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
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
