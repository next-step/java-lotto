package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class LotteryNumbers {
    private final Set<LottoBall> winningNumbers;
    private final LottoBall bonusNumber;

    public LotteryNumbers(final Set<Integer> winningNumbers, final int bonusNumber) {
        this.winningNumbers = winningNumbers.stream().map(LottoBall::getLottoBall).collect(Collectors.toSet());
        this.bonusNumber = LottoBall.getLottoBall(bonusNumber);
    }

    public Set<LottoBall> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoBall getBonusNumber() {
        return bonusNumber;
    }

    public WinningGrade getWinningGrade(final Lotto lotto) {
        return WinningGrade.checkWinningGrade(lotto.matchWinningCount(this.winningNumbers), lotto.isMatchBonus(this.bonusNumber));
    }

}
