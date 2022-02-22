package lotto.domain;

import java.util.List;

public class LottoMachine {

    private final List<LottoNumber> winNumbers;
    private final LottoNumber bonusNumber;

    public LottoMachine(final List<LottoNumber> winNumbers, final LottoNumber bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isEqualBonusNumber(final LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }

    public boolean isContain(final LottoNumber lottoNumber) {
        return winNumbers.contains(lottoNumber);
    }
}
