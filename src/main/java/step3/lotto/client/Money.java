package step3.lotto.client;

import step3.lotto.exception.NotEnoughMoneyException;

public class Money {

    private long value;

    public Money(long value) {
        this.value = value;
    }

    public void plus(long value) {
        this.value += value;
    }

    public void minus(long value) {
        if(this.value - value < 0)
            throw new NotEnoughMoneyException("로또 살 돈이 부족합니다");

        this.value -= value;
    }

    public long getValue() {
        return value;
    }
}
