package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);

        this.number = number;
    }

    private void validateNumberRange(final int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("복권의 숫자 범위가 유효하지 않습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if (this.number > lottoNumber.number) {
            return 1;
        }
        if (this.number == lottoNumber.number) {
            return 0;
        }

        return -1;
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
}
