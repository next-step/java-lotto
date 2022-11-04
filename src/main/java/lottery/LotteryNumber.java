package lottery;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LotteryNumber implements Comparable<LotteryNumber>{

    public static final int LOTTERY_NUM_MIN = 1;
    public static final int LOTTERY_NUM_MAX = 45;
    public static Map<Integer, LotteryNumber> lotteryNumbers = new HashMap<>();

    private final int lotteryNumber;

    static {
        for (int i = LOTTERY_NUM_MIN; i <= LOTTERY_NUM_MAX; i++) {
            lotteryNumbers.put(i, new LotteryNumber(i));
        }
    }

    private LotteryNumber(int number) {
        this.lotteryNumber = number;
    }

    public static LotteryNumber lotteryNumber(int number) {
        LotteryNumber lotteryNumber = lotteryNumbers.get(number);
        validate(lotteryNumber);
        return lotteryNumber;
    }

    private static void validate(LotteryNumber lotteryNumber) {
        if (lotteryNumber == null) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 정수여야 합니다.");
        }
    }

    @Override
    public int compareTo(LotteryNumber o) {
        return this.lotteryNumber - o.lotteryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return lotteryNumber == that.lotteryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lotteryNumber);
    }
}
