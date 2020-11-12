package step2.domain.lotto;

import java.util.Objects;

public class LottoNumber {
    public static final int MINIMUM_ANCHOR_POINT = 0;
    public static final int MAXIMUM_ANCHOR_POINT = 45;
    private final int number;

    public LottoNumber(int number) {
        isValid(number);
        this.number = number;
    }

    private void isValid(int number) {
        if (number <= MINIMUM_ANCHOR_POINT || number > MAXIMUM_ANCHOR_POINT) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }

    public String getString() {
        return String.valueOf(number);
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
}
