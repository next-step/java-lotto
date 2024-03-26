package lotto.data;

import lotto.util.MessageUtils;

import java.util.Objects;
import java.util.stream.IntStream;

import static lotto.util.ConstUtils.MAXIMUM_LOTTO_RANGE;
import static lotto.util.ConstUtils.MINIMUM_LOTTO_RANGE;

public class LottoBall {

    private final static LottoBall[] lottoBalls = new LottoBall[MAXIMUM_LOTTO_RANGE + 1];

    static {
        IntStream.rangeClosed(MINIMUM_LOTTO_RANGE, MAXIMUM_LOTTO_RANGE)
                .forEach(number -> lottoBalls[number] = new LottoBall(number));
    }

    private final int ballNumber;

    private LottoBall(int ballNumber) {
        validateLottoBallNumber(ballNumber);

        this.ballNumber = ballNumber;
    }

    public static LottoBall selectLottoBall(int ballNumber) {
        validateLottoBallNumber(ballNumber);

        return lottoBalls[ballNumber];
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LottoBall that = (LottoBall) object;
        return ballNumber == that.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(ballNumber);
    }

    private static void validateLottoBallNumber(int ballNumber) {
        if (ballNumber < MINIMUM_LOTTO_RANGE || ballNumber > MAXIMUM_LOTTO_RANGE) {
            throw new IllegalArgumentException(MessageUtils.LOTTO_RANGE_VALIDATION_MESSAGE);
        }
    }
}
