package step2;

public class Money {
    private final int amount;

    Money(int amount) {
        this.amount = amount;
    }

    public static Money of(String amount) {
        return new Money(Integer.parseInt(amount));
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public int getAffordableTicketCount(int ticketPrice) {
        return amount / ticketPrice;
    }
}
