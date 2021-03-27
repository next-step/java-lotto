package study.lotto.domain;

import study.lotto.exception.LottoException;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import static study.lotto.service.LottoFactory.LOTTO_MAX_SIZE;
import static study.lotto.util.Constants.GUIDE_ERR_LOTTO_SIZE;

/**
 * 하나의 로또 게임 하나
 */
public class Lotto {

    private final Set<LottoNumber> lottoNumbers;

    Lotto(final Collection<LottoNumber> lottoNumbers) {
        checkValidation(lottoNumbers);
        this.lottoNumbers = getLottoNumbers(lottoNumbers);
    }

    public static Lotto of(final Collection<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    private void checkValidation(final Collection<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_MAX_SIZE) {
            throw new LottoException(GUIDE_ERR_LOTTO_SIZE);
        }
    }

    private Set<LottoNumber> getLottoNumbers(final Collection<LottoNumber> lottoNumbers) {
        return new TreeSet<>(lottoNumbers);
    }

    public long match(final Lotto winningLotto) {
        return lottoNumbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean contains(final LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        final Lotto lotto1 = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto1.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
