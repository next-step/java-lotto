package step3.domain;

import static step3.domain.generator.LottoAutoGenerator.END_NUMBER;
import static step3.domain.generator.LottoAutoGenerator.START_NUMBER;

public class LottoNumber {

    private int number;

    public LottoNumber(int number) {
        this.number = number;
        if (!isLotto()) throw new IllegalArgumentException();
    }

    public boolean isLotto() {
        return number >= START_NUMBER && number <= END_NUMBER;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber lottoNumber1 = (LottoNumber) o;

        return number == lottoNumber1.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
