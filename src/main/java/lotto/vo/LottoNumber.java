package lotto.vo;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "입력 값의 범위 맞지 않습니다.";
    private static final String EMPTY_EXCEPTION_MESSAGE = "입력 값은 빈 값 일 수 없습니다.";
    private static final LottoNumber[] oneThroughFourthFive = {
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6), new LottoNumber(7), new LottoNumber(8),
            new LottoNumber(9), new LottoNumber(10), new LottoNumber(11), new LottoNumber(12),
            new LottoNumber(13), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16),
            new LottoNumber(17), new LottoNumber(18), new LottoNumber(19), new LottoNumber(20),
            new LottoNumber(21), new LottoNumber(22), new LottoNumber(23), new LottoNumber(24),
            new LottoNumber(25), new LottoNumber(26), new LottoNumber(27), new LottoNumber(28),
            new LottoNumber(29), new LottoNumber(30), new LottoNumber(31), new LottoNumber(32),
            new LottoNumber(33), new LottoNumber(34), new LottoNumber(35), new LottoNumber(36),
            new LottoNumber(37), new LottoNumber(38), new LottoNumber(39), new LottoNumber(40),
            new LottoNumber(41), new LottoNumber(42), new LottoNumber(43), new LottoNumber(44),
            new LottoNumber(45)
    };

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber getCachedLottoNumber(int number) {
        if (number < LottoRule.START_NUMBER.getValue() || number > LottoRule.END_NUMBER.getValue()) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
        return oneThroughFourthFive[number - 1];
    }

    public static LottoNumber create(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION_MESSAGE);
        }

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }

        int value = Integer.parseInt(input);

        return getCachedLottoNumber(value);
    }

    public static LottoNumber create(int value) {
        return getCachedLottoNumber(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
    }
}
