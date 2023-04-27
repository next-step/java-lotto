package step2.service;

import step2.vo.LottoNumbers;

public class LottoNumberGenerator {

    private final LottoNumbers lottoNumbers;

    public LottoNumberGenerator() {
        this.lottoNumbers = new LottoNumbers();
    }

    public Lotto generateLottoNumbers() {
        return lottoNumbers.pickSixNumbers();
    }
}
