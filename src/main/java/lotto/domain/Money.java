package lotto.domain;

import lotto.exception.InvalidMoneyException;

public class Money {
    private static final String INVALID_READ_MONEY_ERROR_MESSAGE = "구매 금액을 제대로 입력해주세요.";
    private static final String INVALID_DIVIDE_ERROR_MESSAGE = "0으로 나눌 수 없습니다.";
    private final long ticketPrice;

    public Money(String stringPrice) {
        this(parseLong(stringPrice));
    }

    public Money(long ticketPrice) {
        validMoney(ticketPrice);
        this.ticketPrice = ticketPrice;
    }

    private void validMoney(long ticketPrice) {
        if (ticketPrice < 0) {
            throw new InvalidMoneyException();
        }
    }

    public long getTicketPrice() {
        return ticketPrice;
    }

    public Money subtract(Money money) {
        return new Money(this.ticketPrice - money.ticketPrice);
    }

    public double divide(Money money) {
        if (money.isZero()) {
            throw new ArithmeticException(INVALID_DIVIDE_ERROR_MESSAGE);
        }
        return (double) this.ticketPrice / money.ticketPrice;
    }

    private boolean isZero() {
        return this.equals(new Money(0));
    }
    private static long parseLong(String input) {
        long longValue;
        try {
            longValue = Long.parseLong(input);
        } catch (RuntimeException e) {
            throw new NumberFormatException(INVALID_READ_MONEY_ERROR_MESSAGE);
        }
        return longValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return ticketPrice == money.ticketPrice;
    }

    @Override
    public int hashCode() {
        return (int) (ticketPrice ^ (ticketPrice >>> 32));
    }
}
