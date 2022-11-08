package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LotteryNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_NUMBER = 45;

    public static final Map<Integer, LotteryNumber> cacheNumbers;
    private final int number;

    static {
        cacheNumbers = new HashMap<>();
        for (int i = MIN_VALUE; i <= MAX_NUMBER; i++) {
            cacheNumbers.put(i, new LotteryNumber(i));
        }
    }

    private LotteryNumber(int number) {
        this.number = number;
    }

    private static int parseInt(String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new LotteryGameException(ErrorCode.NULL_OR_EMPTY);
        }
        return Integer.parseInt(number);
    }

    public static LotteryNumber valueOf(int number) {
        validateRange(number);
        return cacheNumbers.get(number);
    }

    public static LotteryNumber valueOf(String number) {
        return valueOf(parseInt(number));
    }

    private static void validateRange(int number) {
        if (number < MIN_VALUE || number > MAX_NUMBER) {
            throw new LotteryGameException(ErrorCode.OUT_OF_RANGE_NUMBER);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
