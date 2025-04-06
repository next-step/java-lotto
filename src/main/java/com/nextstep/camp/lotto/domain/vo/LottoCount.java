package com.nextstep.camp.lotto.domain.vo;

import java.util.stream.IntStream;

import com.nextstep.camp.lotto.domain.exception.LottoCountCannotBeNegativeException;

public class LottoCount {
    private final int value;

    private LottoCount(int value) {
        validate(value);
        this.value = value;
    }

    private static void validate(int value) {
        if (value < 0) {
            throw new LottoCountCannotBeNegativeException();
        }
    }

    public static LottoCount of(int intValue) {
        return new LottoCount(intValue);
    }

    public int getCount() {
        return value;
    }

    public IntStream intStream() {
        return IntStream.range(0, value);
    }

    public LottoCount minus(LottoCount other) {
        validateMinus(other);
        return LottoCount.of(this.value - other.value);
    }

    private void validateMinus(LottoCount other) {
        if (this.value < other.value) {
            throw new LottoCountCannotBeNegativeException();
        }
    }

    @Override
    public String toString() {
        return "LottoCount{" +
                "count=" + value +
                '}';
    }
}
