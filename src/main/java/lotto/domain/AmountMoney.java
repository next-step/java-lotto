package lotto.domain;

import java.util.Objects;

public class AmountMoney {

    private static final int LOTTO_TICKET_PRICE = 1000;

    private int money;

    private AmountMoney(int money) {
        this.money = money;
    }

    public static AmountMoney create(int inputAmountMoney) {
        if (inputAmountMoney < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("최소 구입금액은 1000원입니다.");
        }
        return new AmountMoney(inputAmountMoney);
    }

    public int couldBuyTicketAmount() {
        return money / LOTTO_TICKET_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmountMoney that = (AmountMoney) o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
