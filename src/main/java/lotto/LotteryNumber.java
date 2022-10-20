package lotto;

public class LotteryNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LotteryNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_VALUE || number > MAX_NUMBER) {
            throw new LotteryGameException(ErrorCode.OUT_OF_RANGE_NUMBER);
        }
    }

}
