package domain;

public class WinningNumbers {
    private LottoNumbers winningNumbers;
    private int bonusBall;

    public WinningNumbers(LottoNumbers winningNumbers, int bonusBall) {
        if (winningNumbers.isContains(bonusBall)) {
            throw new IllegalArgumentException("당첨번호와 보너스볼 숫자가 같을 수 없습니다.");
        }

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