package step2.service;

import step2.vo.LottoNumbers;

import java.util.List;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean containWinNum(int winNum) {
        return lottoNumbers.containWinNum(winNum);
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers.lottoNumbers();
    }
}
