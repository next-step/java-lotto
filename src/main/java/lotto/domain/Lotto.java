package lotto.domain;

public class Lotto {

    private static final int TICKET_AMOUNT = 1000;
    private final int ticketCount;

    public Lotto(int amount) {
        this.ticketCount = convertAmountToTicketCount(amount);
    }

    public static int convertAmountToTicketCount(int amount) {
        return amount / TICKET_AMOUNT;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
