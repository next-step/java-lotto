package lotto.vo;

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

    public Ranks getWinningStatistics(LotteryNumber winningNumber) {
        return lotteryNumbers.getRanks(winningNumber);
    }
}