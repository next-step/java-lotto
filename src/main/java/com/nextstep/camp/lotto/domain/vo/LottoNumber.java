package com.nextstep.camp.lotto.domain.vo;

import java.util.Objects;

public class LottoNumber {
    private final int value;

    public LottoNumber(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
