package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LotteryNumber {

    private final int number;
    private static final Map<Integer, LotteryNumber> numberCache = new HashMap<>();

    private LotteryNumber(int number) {
        this.number = number;
    }

    public static LotteryNumber of(int number) {
        return numberCache.computeIfAbsent(number, key -> {
            validate(number);
            return new LotteryNumber(number);
        });
    }

    private static void validate(int number) {
        if (number < LotteryEnum.LOTTERY_MIN.value() || number > LotteryEnum.LOTTERY_MAX.value()) {
            throw new IllegalArgumentException("잘못된 로또 번호입니다.");
        }
    }

    public int value() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
