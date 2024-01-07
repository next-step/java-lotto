package lotto.domain;

import java.util.Objects;

public class Money {
    private static int PRICE_OF_TICKET = 1000;

    private int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public int calculateNumberOfTicket() {
        return amount / PRICE_OF_TICKET;
    }

    public float calculateRateOfReturn(LottoResult lottoResult) {
        return (float) lottoResult.totalPrizeAmount().amount / (float) amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
