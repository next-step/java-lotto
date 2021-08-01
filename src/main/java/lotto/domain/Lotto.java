package lotto.domain;

import lotto.application.CreateLottoNumbersStrategy;

import java.util.List;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(CreateLottoNumbersStrategy createLottoNumbersStrategy) {
        this.lottoNumbers = new LottoNumbers(createLottoNumbersStrategy.getNumbersList());
    }

    public Lotto(LottoNumbers lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.getLottoNumbers();
    }
}
