package lotto.domain;

import java.util.Set;

public class LotteryNumbers {
    private final Lotto winningNumbers;
    private final LottoBall bonusNumber;

    public LotteryNumbers(final Set<Integer> winningNumbers, final int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = LottoBall.getLottoBall(bonusNumber);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public LottoBall getBonusNumber() {
        return bonusNumber;
    }

    public WinningGrade getWinningGrade(final Lotto lotto) {
        return WinningGrade.checkWinningGrade(lotto.matchWinningCount(this.winningNumbers), lotto.isMatchBonus(this.bonusNumber));
    }

}
