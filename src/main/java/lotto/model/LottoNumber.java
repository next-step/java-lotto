package lotto.model;

import lotto.exception.InvalidLottoNumberException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private int value;

    public LottoNumber(String value) {
        this.value = Integer.valueOf(value);

        if (this.value > 45 || this.value < 1) {
            throw new InvalidLottoNumberException(String.format("[범위 오류] 유효하지 않는 로또 숫자가 입력 되었습니다. %s", value));
        }
    }

    public LottoNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return value == lottoNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber no) {
        return this.value - no.value;
    }
}
