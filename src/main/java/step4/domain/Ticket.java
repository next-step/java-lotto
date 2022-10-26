package step4.domain;

public class Ticket {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private final int countOfTicket;

    private Ticket(final int countOfTicket) {
        this.countOfTicket = countOfTicket;
    }

    public static final Ticket from(final int ticketCount) {
        return new Ticket(ticketCount);
    }

    public final int getCountOfTicket() {
        return countOfTicket;
    }

    public final int getPurchasePrice(){
        return countOfTicket * LOTTO_TICKET_PRICE;
    }
}
