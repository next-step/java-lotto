package lotto.domain.lotto;

import lotto.domain.lotto.wrapper.LottoNumbers;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto() {
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatchingNumbers(LottoNumbers winningLottoNumbers) {
        return this.lottoNumbers.countMatchingNumbers(winningLottoNumbers);
    }
}
