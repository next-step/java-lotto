package lotto.domain.lotto;

import lotto.domain.lotto.wrapper.LottoNumber;
import lotto.domain.lotto.wrapper.LottoNumbers;

public class Lotto {

    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(LottoNumbers winningLottoNumbers) {
        return this.lottoNumbers.countMatchingNumbers(winningLottoNumbers);
    }

    public boolean isBonusNumEqualWith(LottoNumber winningBonusNum) {
        return this.bonusNumber.equals(winningBonusNum);
    }
}
