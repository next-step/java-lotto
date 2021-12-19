package lottery.domain;

import java.util.Objects;

public class LotteryNumber implements Comparable<LotteryNumber> {

    public static final int MINIMUM_LOTTERY_NUMBER = 1;
    public static final int MAXIMUM_LOTTERY_NUMBER = 45;
    private static final String EXCEPTION_MESSAGE_INVALID_NUMBER_FORMAT = "로또 번호는 %d~%d 만 허용됩니다. input: %d";

    private final int value;

    private LotteryNumber(final int value) {
        this.value = value;
    }

    public static LotteryNumber from(final int input) {
        if (isInvalidNumber(input)) {
            final String exceptionMessage = String.format(EXCEPTION_MESSAGE_INVALID_NUMBER_FORMAT,
                MINIMUM_LOTTERY_NUMBER,
                MAXIMUM_LOTTERY_NUMBER,
                input);
            throw new IllegalArgumentException(exceptionMessage);
        }

        return new LotteryNumber(input);
    }

    public int value() {
        return value;
    }

    private static boolean isInvalidNumber(final int input) {
        return input > MAXIMUM_LOTTERY_NUMBER || input < MINIMUM_LOTTERY_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LotteryNumber that = (LotteryNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LotteryNumber lotteryNumber) {
        return this.value - lotteryNumber.value;
    }
}
