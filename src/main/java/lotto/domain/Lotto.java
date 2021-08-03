package lotto.domain;

import lotto.application.CreateLottoNumbersStrategy;

import java.util.List;

import static lotto.domain.LottoPrize.*;

public class Lotto {
    private LottoNumbers lottoNumbers;
    private BonusNumber bonusNumber;

    public Lotto(CreateLottoNumbersStrategy createLottoNumbersStrategy) {
        this.lottoNumbers = new LottoNumbers(createLottoNumbersStrategy.getNumbersList());
    }

    public Lotto(LottoNumbers lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.getLottoNumbers();
    }

    public int checkWinning(Lotto comparedLotto) {
        int prize = this.lottoNumbers.checkWinning(comparedLotto.getLottoNumbers());
        prize = checkBonusNumber(comparedLotto, prize);
        return prize;
    }

    private int checkBonusNumber(Lotto lotto, int prize) {
        if (prize == SECOND.getPrize() && !lotto.isContainBonusNumber(bonusNumber.getBonusNumber())) {
            prize = THIRD.getPrize();
        }
        return prize;
    }

    public int getBonusNumber() {
        return this.bonusNumber.getBonusNumber();
    }

    public boolean isContainBonusNumber(int bonusNumber) {
        return this.lottoNumbers.isContainBonusNumber(bonusNumber);
    }
}
