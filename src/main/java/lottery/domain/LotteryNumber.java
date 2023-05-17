package lottery.domain;

public class LotteryNumber implements Comparable<LotteryNumber> {
    public static final int MAX = 45;
    public static final int MIN = 1;

    private final int value;

    public LotteryNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < LotteryNumber.MIN || value > LotteryNumber.MAX) {
            throw new IllegalArgumentException(String.format("%s is not valid ", value));
        }
    }

    public int value() {
        return value;
    }

    @Override
    public int compareTo(LotteryNumber lotteryNumber) {
        return this.value - lotteryNumber.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LotteryNumber that = (LotteryNumber) o;
        return value == that.value;
    }

    @Override
    public String toString() {
        return "LottoNumber(" + value + ')';
    }
}
