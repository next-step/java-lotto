package lotto.domain;

public class LottoWinBonusNumber {
    private final int bonusNumber;

    public LottoWinBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
        this.bonusNumber = bonusNumber;
    }

    public boolean isMatch(Integer lottoNum) {
        return bonusNumber == lottoNum;
    }
}
