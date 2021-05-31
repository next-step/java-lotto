package lottery.domain;

public class WinnerLottery {

    private final LotteryNumbers lotteryNumbers;

    public WinnerLottery(LotteryNumbers lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public int match(LotteryNumbers input) {
        int matchCount = 0;

        for (LotteryNumber number : lotteryNumbers.numbers()) {

            if (input.numbers().contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }
}
