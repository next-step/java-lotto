package lottery.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LotteryNumber {
    private static final int LOTTERY_MIN_NUMBER = 1;
    private static final int LOTTERY_MAX_NUMBER = 45;

    private final int number;

    public LotteryNumber(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자만 가능합니다.");
        }
        this.number = number;
    }

    private static boolean isInRange(int number) {
        return number >= LOTTERY_MIN_NUMBER && number <= LOTTERY_MAX_NUMBER;
    }

    public static List<Integer> getAllLotteryNumbers() {
        List<Integer> allLotteryNumbers = new ArrayList<>();
        for (int i = LOTTERY_MIN_NUMBER; i <= LOTTERY_MAX_NUMBER; i++) {
            allLotteryNumbers.add(i);
        }
        return allLotteryNumbers;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
