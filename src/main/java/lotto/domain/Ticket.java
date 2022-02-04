package lotto.domain;

public class Ticket {

    private static final int TICKET_PRICE = 1000;

    private int buyCount;

    public Ticket(int money) {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException("[ERROR] 최소 구매 금액은 1,000원입니다.");
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
