package lottery.domain;

public class LotteryNumber {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private final int lotteryNumber;

    public LotteryNumber(int lotteryNumber) {
        validateLotteryNumber(lotteryNumber);
        this.lotteryNumber = lotteryNumber;
    }

    private void validateLotteryNumber(int lotteryNumber) {
        if (lotteryNumber < MINIMUM_NUMBER || lotteryNumber > MAXIMUM_NUMBER)
            throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE);
    }

    public int getLotteryNumber() {
        return lotteryNumber;
    }
}
