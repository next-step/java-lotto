package lotto.backend.domain;

public class Money {
    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public int howManyLottoTickets(int pricePerMoney) {
        return value / pricePerMoney;
    }
}
