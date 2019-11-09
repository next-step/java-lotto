package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by yusik on 2019/11/08.
 */
public class LotteryNumber {

    public static final int LOTTERY_NUMBER_MIN = 1;
    public static final int LOTTERY_NUMBER_MAX = 45;
    private static final String RANGE_ERROR_MESSAGE =
            String.format("복권 번호의 범위는 [%d, %d] 입니다.", LOTTERY_NUMBER_MIN, LOTTERY_NUMBER_MAX);
    private static final Map<Integer, LotteryNumber> CACHE = new HashMap<>();

    private int number;

    static {
        for (int i = LOTTERY_NUMBER_MIN; i <= LOTTERY_NUMBER_MAX; i++) {
            CACHE.put(i, new LotteryNumber(i));
        }
    }

    private LotteryNumber(int number) {
        if (number < LOTTERY_NUMBER_MIN || number > LOTTERY_NUMBER_MAX) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
        this.number = number;
    }

    public static LotteryNumber of(int number) {
        return Optional.ofNullable(CACHE.get(number))
                .orElseThrow(() -> new IllegalArgumentException(RANGE_ERROR_MESSAGE));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LotteryNumber)) return false;

        LotteryNumber that = (LotteryNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
