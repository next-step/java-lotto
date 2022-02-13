package lotto.domain;

public class Ticket {

    private static final String TICKET_ERROR_MESSAGE = "최소 구매 금액은 1,000원입니다.";
    private static final int TICKET_PRICE = 1000;

    private final int buyCount;

    public Ticket(final int money) {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException(TICKET_ERROR_MESSAGE);
        }
        this.buyCount = money / TICKET_PRICE;
    }

    public int getBuyCash() {
        return this.buyCount * TICKET_PRICE;
    }

    public int getBuyCount() {
        return this.buyCount;
    }
}
