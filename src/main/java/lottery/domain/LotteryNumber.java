package lottery.domain;

public class LotteryNumber {

    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    private final int lotteryNumber;

    private LotteryNumber(int lotteryNumber) {
        validateLotteryNumber(lotteryNumber);
        this.lotteryNumber = lotteryNumber;
    }

    public static LotteryNumber from(int lotteryNumber) {
        return new LotteryNumber(lotteryNumber);
    }

    private void validateLotteryNumber(int lotteryNumber) {
        if (lotteryNumber < MINIMUM_NUMBER || lotteryNumber > MAXIMUM_NUMBER)
            throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE);
    }

    public int getLotteryNumber() {
        return lotteryNumber;
    }
}
