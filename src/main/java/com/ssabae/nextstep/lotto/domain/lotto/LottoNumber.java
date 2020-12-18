package com.ssabae.nextstep.lotto.domain.lotto;

import java.util.Objects;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
public class LottoNumber {

    private final int number;

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
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
