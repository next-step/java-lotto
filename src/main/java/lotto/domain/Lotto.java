package lotto.domain;

import lotto.application.CreateLottoNumbersStrategy;

import java.util.List;

public class Lotto {
    private LottoNumbers lottoNumbers;
    private BonusNumber bonusNumber;

    public Lotto(CreateLottoNumbersStrategy createLottoNumbersStrategy) {
        this.lottoNumbers = new LottoNumbers(createLottoNumbersStrategy.getNumbersList());
    }

    public Lotto(LottoNumbers lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.getLottoNumbers();
    }


    public int checkWinning(Lotto lotto) {
        return this.lottoNumbers.checkWinning(lotto.getLottoNumbers());
    }

    public void createBonusNumber(String bonusNumberString) {
        this.bonusNumber = new BonusNumber(bonusNumberString);
    }

    public BonusNumber getBonusNumber() {
        return this.bonusNumber;
    }
}
