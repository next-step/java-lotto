package step2.domain;

import static step2.domain.LottoGenerator.LOTTO_FIRST_NUMBER;
import static step2.domain.LottoGenerator.LOTTO_LAST_NUMBER;

import java.util.Objects;

public class LottoNumber {

    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isValid() {
        if (number < LOTTO_FIRST_NUMBER || number > LOTTO_LAST_NUMBER) {
            return false;
        }
        return true;
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
        return String.valueOf(number);
    }
}
