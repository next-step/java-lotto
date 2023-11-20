package com.fineroot.lotto.entity;

import com.fineroot.lotto.util.ExceptionMessage;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int value;

    private LottoNumber(int number){
        if(number <= 0 || number > 45){
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
        value = number;
    }

    public static LottoNumber from(int number){
        return new LottoNumber(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
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
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
