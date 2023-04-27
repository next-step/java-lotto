package step2.service;

import step2.vo.LottoNumbers;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean containWinNum(int winNum) {
        return lottoNumbers.containWinNum(winNum);
    }

    public String toStringLottoNumbers() {
        return this.lottoNumbers.toStringLottoNumbers();
    }
}
