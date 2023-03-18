package lotto.domain;


import java.util.Arrays;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(final int bonusNumber, final int... winningNumbers) {
        if (isContainBonusNumber(bonusNumber, winningNumbers)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
        this.winningNumbers = new Lotto(winningNumbers);;
        this.bonusNumber = LottoNumber.from(bonusNumber);
    }

    private boolean isContainBonusNumber(int bonusNumber, int[] winningNumbers) {
        return Arrays.stream(winningNumbers).anyMatch(n -> bonusNumber == n);
    }

    public WinningGrade getWinningGrade(final Lotto lotto) {
        return WinningGrade.from(lotto.matchCount(this.winningNumbers), lotto.isContains(this.bonusNumber));
    }

    public int matchWinningCount(Lotto lotto) {
        return this.winningNumbers.matchCount(lotto);
    }

    public boolean isMatchBonus(Lotto lotto) {
        return lotto.isContains(bonusNumber);
    }
}
