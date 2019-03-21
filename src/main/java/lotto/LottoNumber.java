package lotto;

import java.util.Objects;

public class LottoNumber {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    private final int number;

    public LottoNumber(final int number) {
        if (isInvalidNumber(number)) {
            throw new IllegalArgumentException("로또번호는 1~45 사이에 있어야 합니다.");
        }
        this.number = number;
    }

    private boolean isInvalidNumber(int number) {
        return number > MAXIMUM_NUMBER || MINIMUM_NUMBER > number;
    }

    public LottoNumber increase() {
        int increasingNumber = this.number + MINIMUM_NUMBER;
        int temp = increasingNumber % LottoNumber.MAXIMUM_NUMBER;
        return temp == LottoGenerator.BASE_INDEX ? new LottoNumber(LottoNumber.MAXIMUM_NUMBER) : new LottoNumber(temp);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number + "";
    }
}
