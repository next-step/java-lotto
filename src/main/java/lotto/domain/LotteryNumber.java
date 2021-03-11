package lotto.domain;

public class LotteryNumber {

    public static final int MAX_VALUE = 45;

    public static final int MIN_VALUE = 1;

    private final int value;

    public LotteryNumber(int value) {
        validateValue(value);
        this.value = value;
    }

    public static LotteryNumber valueOf(int value) {
        return new LotteryNumber(value);
    }

    private void validateValue(int value) {
        if (value > MAX_VALUE || value < MIN_VALUE) {
            throw new IllegalArgumentException("로또번호로는 적합하지 않습니다.");
        }
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
