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
        validateBonusNumber(bonusNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        if(lottoNumbers.isContainBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호에 들어갈 수 없습니다.");
        }
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

    private int checkBonusNumber(Lotto comparedLotto, int prize) {
        if (prize == SECOND.getPrize() && !comparedLotto.isContainBonusNumber(bonusNumber.getBonusNumber())) {
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
