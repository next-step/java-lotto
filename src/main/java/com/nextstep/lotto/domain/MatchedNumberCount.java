package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidMatchedNumberCountException;

public class MatchedNumberCount {
    private final int value;

    public MatchedNumberCount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < 0 || value > 6) {
            throw new InvalidMatchedNumberCountException("일치하는 로또 번호의 수는 1 ~ 6 사이여야만 합니다.");
        }
    }
}
