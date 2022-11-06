package lotto.backend.domain;

public class Money {
    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public int howManyLottoTickets(int pricePerMoney) {
        return value / pricePerMoney;
    }

    public double calculateRatio(Money money) {
        return (double) value / money.value;
    }
}
