package lotto.vo;

import java.util.Map;

public class LotteryGame {
    private LotteryNumbers lotteryNumbers;

    public LotteryGame(Money money) {
        lotteryNumbers = lotteryGenerator(money);
    }

    public LotteryNumbers getLottoNumber() {
        return lotteryNumbers;
    }

    private LotteryNumbers lotteryGenerator(Money money) {
        return new LotteryGenerator().lotteryGenerator(money);
    }

    public Map<Rank, Integer> getWinningStatistics(LotteryNumber winningNumber) {
        return lotteryNumbers.getRank(winningNumber);
    }
}