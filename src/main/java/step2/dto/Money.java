package step2.dto;

import step2.exception.MoneyException;

import java.util.Objects;

public class Money {
    private static final int BASE_PRICE = 1000;
    private static final int ZERO = 0;
    private final int myMoney;

    public Money(int price) {
        validPrice(price);

        this.myMoney = price;
    }

    public Ticket purchasedTicket() {
        return new Ticket(this.myMoney / BASE_PRICE);
    }

    private void validPrice(int price) {
        if (ZERO >= price) {
            throw new MoneyException(MoneyException.ErrorCode.MONEY_NOT_ZERO);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return myMoney == money.myMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(myMoney);
    }
}
