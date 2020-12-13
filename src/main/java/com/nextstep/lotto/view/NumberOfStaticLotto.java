package com.nextstep.lotto.view;

import com.nextstep.lotto.view.exceptions.InvalidNumberOfStaticLottoException;

public class NumberOfStaticLotto {
    private static final int MIN_VALUE = 0;

    private final int value;

    public NumberOfStaticLotto(final int value) {
        validate(value);

        this.value = value;
    }

    private void validate(final int value) {
        if (value < MIN_VALUE) {
            throw new InvalidNumberOfStaticLottoException("수동 로또 구입은 0장 이상만 가능합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
