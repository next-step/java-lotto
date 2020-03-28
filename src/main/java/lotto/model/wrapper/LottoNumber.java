package lotto.model.wrapper;

import java.util.Objects;

import static lotto.utils.LottoConstant.LOTTO_MAX_NUMBER;
import static lotto.utils.LottoConstant.LOTTO_MIN_NUMBER;

public class LottoNumber implements Comparable<LottoNumber> {
    private Integer number;

    private LottoNumber(Integer number) {
        this.number = number;
    }

    public static LottoNumber newInstance(Integer number) {
        validateRange(number);
        return new LottoNumber(number);
    }

    private static void validateRange(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("Lotto Ticket must have six distinct number.");
        }
    }

    public int toInt() {
        return number;
    }

    @Override
    public String toString() {
        return number.toString();
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number.compareTo(o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
