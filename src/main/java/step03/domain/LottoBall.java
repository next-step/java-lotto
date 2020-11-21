package step03.domain;

import exception.OutOfLottoNumberRangeException;

import java.util.Objects;

public class LottoBall {
    private final int number;
    private static final int START = 1;
    private static final int END = 45;

    private LottoBall(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoBall of(int number) {
        return new LottoBall(number);
    }

    private void validate(int number) {
        if (number < START || number > END) {
            throw new OutOfLottoNumberRangeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBall lottoBall = (LottoBall) o;
        return number == lottoBall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
