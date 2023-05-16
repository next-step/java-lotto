package lotto.model;

public class Cost {
    public static final int ONE_LOTTO_TICKET_PRICE = 1_000;
    private final Money money;

    public Cost(Money money) {
        this.money = money;
    }

    public int getMoney() {
        return money.amount();
    }

    public int getLottoTicketCount() {
        return money.amount() / this.ONE_LOTTO_TICKET_PRICE;
    }

}
