package lotto.strategy;

import lotto.model.LottoNumbers;

public class ManualLotto implements LottoStrategy{
    private final LottoNumbers lottoNumbers;

    public ManualLotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public LottoNumbers generateSixNumber() {
        return new LottoNumbers(this.lottoNumbers.lottoNumbers());
    }

}
