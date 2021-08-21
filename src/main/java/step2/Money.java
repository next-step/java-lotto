package step2;

public class Money {
    private static final int TICKET_PRICE = 1000;
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getTotalLottoTicketCount() {
        return money / TICKET_PRICE;
    }
}
