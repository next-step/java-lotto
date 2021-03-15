package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LotteryNumber {

    public static final int MAX_VALUE = 45;

    public static final int MIN_VALUE = 1;

    private static Map<Integer, LotteryNumber> lotteryNumberMap = new HashMap<>();

    private final int value;

    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            lotteryNumberMap.put(i, new LotteryNumber(i));
        }
    }

    private LotteryNumber(int value) {
        this.value = value;
    }

    public static LotteryNumber valueOf(int value) {
        if (!lotteryNumberMap.containsKey(value)) {
            throw new IllegalArgumentException("로또번호로는 적합하지 않습니다.");
        }
        return lotteryNumberMap.get(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LotteryNumber that = (LotteryNumber) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public int getValue() {
        return value;
    }
}
