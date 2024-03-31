package lotto;

import java.util.Objects;

public class LottoNumber {

    public final static int MINIMUM_NUMBER = 1;
    public final static int MAXIMUM_NUMBER = 45;

    private final int number;

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    public LottoNumber(int number) {
        validNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validNumberRange(int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(
                String.format("로또 숫자는 %d~%d 사이 숫자여야 합니다.", MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
