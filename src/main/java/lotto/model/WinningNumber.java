package lotto.model;

public class WinningNumber {

    private LottoNumbers winningNumbers;
    private Number bonusBall;

    public WinningNumber(LottoNumbers winningNumbers, Number bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    Number getBonusBall() {
        return bonusBall;
    }
}
