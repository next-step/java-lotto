package lottery;

import java.util.Objects;
import java.util.Random;

public class LotteryNumber implements Comparable<LotteryNumber> {
    private static final Integer MAX_NUM = 45;
    private static final Integer MIN_NUM = 1;

    private static final Random random = new Random();

    private final Integer number;

    private LotteryNumber(Integer number) {
        checkLotteryNumberInRange(number);
        this.number= number;
    }

    public static LotteryNumber fromGiven(Integer number) {
        return new LotteryNumber(number);
    }

    public static LotteryNumber fromRandom() {
        return new LotteryNumber(getRandomNumber());
    }

    public Integer value() {
        return number;
    }

    private void checkLotteryNumberInRange(Integer number) {
        if (number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException("Lottery number out of range");
        }
    }

    private static Integer getRandomNumber() {
        return random.nextInt(LotteryNumber.MAX_NUM) + LotteryNumber.MIN_NUM;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        var lotteryNumber = (LotteryNumber) object;
        return Objects.equals(number, lotteryNumber.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LotteryNumber other) {
        return Integer.compare(number, other.number);
    }
}
