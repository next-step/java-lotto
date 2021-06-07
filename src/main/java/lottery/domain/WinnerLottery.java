package lottery.domain;

public class WinnerLottery {

    public static final int MATCH_COUNT = 1;
    public static final int DEFAULT_MATCH_COUNT = 0;

    private final LotteryNumbers winnerNumbers;

    public WinnerLottery(LotteryNumbers winnerNumbers) {
        this.winnerNumbers = winnerNumbers;
    }

    public int match(LotteryNumbers input) {
        return winnerNumbers.match(input);
    }

    public boolean contains(LotteryNumber lotteryNumber) {
        return winnerNumbers.contains(lotteryNumber);
    }
}
