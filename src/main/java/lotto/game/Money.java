package lotto.game;

import lotto.exception.LottoIllegalArgumentException;

import java.util.Objects;

import static lotto.game.LottoMachine.LOTTO_PRICE;

public class Money {
    private final int value;

    public Money(int value) {
        if(value < LOTTO_PRICE) {
            throw LottoIllegalArgumentException.NEGATIVE_AMOUNT;
        }
        this.value = value;
    }

    public int divideByLottoPrice() {
        return value / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
