package lotto.domain;

import lotto.view.Message;

public class Money {
    private int value;

    public Money(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(Message.MONEY.message);
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
