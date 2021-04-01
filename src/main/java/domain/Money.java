package domain;

public class Money {

    private static final int LOTTO_TICKET_PRICE = 1000;

    private int money;
    private int ticketCount;

    public Money(int money) {
        this.money = money;
        this.ticketCount = money / LOTTO_TICKET_PRICE;
    }

    public int getMoney() {
        return money;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
