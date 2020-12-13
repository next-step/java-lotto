package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidMatchedNumberCountException;

public class MatchedNumberCount {
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 6;

    private final int value;

    public MatchedNumberCount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new InvalidMatchedNumberCountException("일치하는 로또 번호의 수는 1 ~ 6 사이여야만 합니다.");
        }
    }
}
