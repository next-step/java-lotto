package lotto.domain;

import lotto.interfaces.LotteryGame;

public class WinningResult {
    private final LotteryGame lotteryGames;
    private final WinningNumbers winningNumbers;

    public WinningResult(LotteryGame lotteryGame, WinningNumbers winningNumbers) {
        this.lotteryGames = lotteryGame;
        this.winningNumbers = winningNumbers;
    }

    public Rank result() {
        int countOfMatchedNumbers = 0;
        for (LotteryNumber number : lotteryGames.getLotteries()) {
            if (winningNumbers.getWinningNumberList().contains(number)) {
                countOfMatchedNumbers++;
            }
        }
        return Rank.valueOf(countOfMatchedNumbers, lotteryGames.getLotteries().contains(LotteryNumber.of(winningNumbers.getBonusNumber())));
    }
}
