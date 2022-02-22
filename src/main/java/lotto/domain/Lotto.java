package lotto.domain;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String ERROR_LOTTO_NUMBER = "로또 번호는 6개여야 합니다.";

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER);
        }
    }

    public int matchWinningLotto(WinningLotto winningLotto) {
        return (int) lottoNumbers.stream()
            .filter(winningLotto::hasContainNumber)
            .count();
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
