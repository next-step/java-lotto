package com.fineroot.lotto.dto;

import com.fineroot.lotto.util.ExceptionMessage;

public class Money {
    private final int value;

    private Money(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ExceptionMessage.MONEY_NEGATIVE.getMessage());
        }
        this.value = value;
    }

    public static Money from(int value) {
        return new Money(value);
    }

    public int getValue() {
        return value;
    }
}
