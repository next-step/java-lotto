package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;

public class WinningTicket {
    private final LotteryTicket winningNumbers;
    private final LotteryNumber bonusBoll;

    public WinningTicket(LotteryTicket winningNumbers, LotteryNumber bonusBoll) {
        validateSameNumber(winningNumbers, bonusBoll);
        this.winningNumbers = winningNumbers;
        this.bonusBoll = bonusBoll;
    }

    private void validateSameNumber(LotteryTicket winningNumbers, LotteryNumber bonusBoll) {
        if (winningNumbers.contain(bonusBoll)) {
            throw new LotteryGameException(ErrorCode.HAS_SAME_NUMBER);
        }
    }
}
