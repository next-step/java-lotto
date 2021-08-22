package step4.lotto.client;

import step4.lotto.exception.ExceptionMessage;
import step4.lotto.exception.NotEnoughMoneyException;

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
            throw new NotEnoughMoneyException(ExceptionMessage.NOT_ENOUGH_MONEY);

        this.value -= value;
    }

    public long getValue() {
        return value;
    }
}
