package lotto.domain;

public class Ticket {

    private static final int TICKET_PRICE = 1000;

    private int buyCount;

    public Ticket(int money) {
        this.buyCount = money / TICKET_PRICE;
    }

    public int getBuyCount() {
        return this.buyCount;
    }
}
