package lottery.domain;

public class WinnerLottery {

    public static final int MATCH_COUNT = 1;

    private final LotteryNumbers lotteryNumbers;

    public WinnerLottery(LotteryNumbers lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public int match(LotteryNumbers input) {
        int matchCount = 0;

        for (LotteryNumber number : lotteryNumbers.numbers()) {
            matchCount = addCountIfContains(input, matchCount, number);
        }

        return matchCount;
    }

    private int addCountIfContains(LotteryNumbers input, int matchCount, LotteryNumber number) {
        if (input.contains(number)) {
            return matchCount + MATCH_COUNT;
        }

        return matchCount;
    }
}
