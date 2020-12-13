package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidMatchedNumberCountException;

import java.util.Objects;

public class MatchedNumberCount {
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 6;

    private final int value;

    public MatchedNumberCount(int value) {
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validate(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new InvalidMatchedNumberCountException("일치하는 로또 번호의 수는 0 ~ 6 사이여야만 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchedNumberCount that = (MatchedNumberCount) o;
        return MIN_VALUE == that.MIN_VALUE && MAX_VALUE == that.MAX_VALUE && value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(MIN_VALUE, MAX_VALUE, value);
    }

    @Override
    public String toString() {
        return "MatchedNumberCount{" +
                "MIN_VALUE=" + MIN_VALUE +
                ", MAX_VALUE=" + MAX_VALUE +
                ", value=" + value +
                '}';
    }
}
