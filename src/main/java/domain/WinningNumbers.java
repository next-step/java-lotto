package domain;

public class WinningNumbers {
    private LottoNumbers winningNumbers;
    private int bonusBall;

    public WinningNumbers(LottoNumbers winningNumbers, int bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public int calcMatchCount(Lotto lotto) {
        return winningNumbers.calcMatchCount(lotto);
    }

    public boolean isContainsBonusBall(Lotto lotto) {
        return lotto.isContains(this.bonusBall);
    }
}