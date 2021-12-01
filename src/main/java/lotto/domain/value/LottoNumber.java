package lotto.domain.value;

import lotto.service.util.Validation;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(int number) {

        Validation.lottoNumberSizeCheck(number);

        this.number = number;
    }

    public int getNumber() {
        return number;
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
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number + "";
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.number - lottoNumber.getNumber();
    }

}
