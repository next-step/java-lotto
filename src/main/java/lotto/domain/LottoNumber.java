package lotto.domain;

import java.util.Arrays;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    public LottoNumber(int number) {
        shouldRange(number);
        this.number = number;
    }

    private void shouldRange(int number) {
        if (number <= 0 || number > 45) {
            throw new InvalidLottoNumberException("로또번호는 1~45 사이 숫자만 허용합니다.");
        }
    }

    public Integer getValue() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public LottoNumberMatcher getNumberMatcher() {
        return new ListLottoNumberMatcher(Arrays.asList(this));
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
    public int compareTo(LottoNumber o) {
        return Integer.valueOf(this.number).compareTo(Integer.valueOf(o.number));
    }
}
