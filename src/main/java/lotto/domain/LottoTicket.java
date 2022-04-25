package lotto.domain;

import lotto.exception.InvalidLottoException;

import java.util.Objects;
import java.util.Set;

public class LottoTicket {

    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validLotto(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new InvalidLottoException();
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket lotto = (LottoTicket) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
