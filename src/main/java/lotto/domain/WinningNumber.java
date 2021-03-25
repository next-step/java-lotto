package lotto.domain;

public class WinningNumber {
    private LottoGame winningNumber;
    private int bonusNumber;

    public WinningNumber(LottoGame winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        if (bonusNumber < LottoRule.min() || bonusNumber > LottoRule.max()) {
            throw new IllegalArgumentException();
        }

        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public boolean matchBonus(LottoGame lottoGame) {
        return lottoGame.contains(bonusNumber);
    }

    public int countOfMatch(LottoGame lottoGame) {
        return winningNumber.countOfMatch(lottoGame);
    }
}
