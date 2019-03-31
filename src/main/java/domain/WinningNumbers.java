package domain;

public class WinningNumbers {
    private LottoNumbers winningNumbers;
    private LottoNo bonusBall;

    public WinningNumbers(LottoNumbers winningNumbers, int bonusBall) {
        if (winningNumbers.isContains(LottoNo.of(bonusBall))) {
            throw new IllegalArgumentException("당첨번호와 보너스볼 숫자가 같을 수 없습니다.");
        }

        this.winningNumbers = winningNumbers;
        this.bonusBall = LottoNo.of(bonusBall);
    }

    public int calcMatchCount(Lotto lotto) {
        return winningNumbers.calcMatchCount(lotto);
    }

    public boolean isContainsBonusBall(Lotto lotto) {
        return lotto.isContains(this.bonusBall);
    }
}