package lotto.domain;

public class WinningNumber {
    private LottoNumber winningNumber;
    private int bonusNumber;

    public WinningNumber(LottoNumber winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        if (bonusNumber < LottoRule.min() || bonusNumber > LottoRule.max()) {
            throw new IllegalArgumentException();
        }

        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public boolean matchBonus(LottoNumber lottoNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    public int countOfMatch(LottoNumber lottoNumber) {
        return winningNumber.countOfMatch(lottoNumber);
    }
}
