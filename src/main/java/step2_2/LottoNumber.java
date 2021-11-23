package step2_2;

import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    private int number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = number;
    }

    private void checkRange(int number) {
        if (number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new InvalidLottoNumberException();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(LottoNumber.class)) {
            return false;
        }
        LottoNumber other = (LottoNumber) o;
        return this.number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
