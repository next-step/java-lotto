package lotto_second.domain;

import lotto_second.util.LottoValidate;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        this.number = validateLottoBound(number);
    }

    public Integer validateLottoBound(Integer number) {
        if (number < LottoValidate.LOTTO_MIN_NUMBER || number > LottoValidate.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("올바르지 않은 로또의 범위 : " + LottoValidate.LOTTO_MIN_NUMBER + "과 " + LottoValidate.LOTTO_MAX_NUMBER + "사이의 값을 입력필요");
        }

        return number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
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
