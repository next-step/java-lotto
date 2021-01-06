package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public LottoNumber(String input) {
        this(Integer.parseInt(input));
    }

    private void validateNumber(int number) {
        if (number < Lotto.LOTTO_MIN_NUMBER || number > Lotto.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 범위가 초과하였습니다.");
        }
    }

    public Integer getNumber() {
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.getNumber().compareTo(o.getNumber());
    }
}
