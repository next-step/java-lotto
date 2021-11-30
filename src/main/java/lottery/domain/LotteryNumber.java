package lottery.domain;

public class LotteryNumber {

    private static final int MINIMUM_LOTTERY_NUMBER = 1;
    private static final int MAXIMUM_LOTTERY_NUMBER = 45;
    private static final String EXCEPTION_MESSAGE_INVALID_NUMBER_FORMAT = "로또 번호는 %d~%d 만 허용됩니다. input: %d";

    final int value;

    private LotteryNumber(final int value) {
        this.value = value;
    }

    public static LotteryNumber of(final int input) {
        if (input > MAXIMUM_LOTTERY_NUMBER || input < MINIMUM_LOTTERY_NUMBER) {
            throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_INVALID_NUMBER_FORMAT, MINIMUM_LOTTERY_NUMBER,
                MAXIMUM_LOTTERY_NUMBER, input));
        }

        return new LotteryNumber(input);
    }
}
