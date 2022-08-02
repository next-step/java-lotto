package lotto.domain;

import lotto.interfaces.LotteryGame;

public class WinningResult {
    private final LotteryGame lotteryGame;
    private final WinningNumbers winningNumbers;

    public WinningResult(LotteryGame lotteryGame, WinningNumbers winningNumbers) {
        this.lotteryGame = lotteryGame;
        this.winningNumbers = winningNumbers;
    }

    public Rank result() {
        return winningNumbers.match(lotteryGame);
    }
}
