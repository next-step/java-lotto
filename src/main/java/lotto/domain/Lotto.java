package lotto.domain;

import lotto.exception.InvalidLottoException;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validLotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new InvalidLottoException();
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
