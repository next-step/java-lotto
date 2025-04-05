package lotto;

public class LottoTicket {

    private TicketType ticketType;
    public static final int TICKET_PRICE = 1000;

    public LottoTicket(boolean isManual) {
        ticketType = TicketType.valueOf(isManual);
    }

    public boolean isManual() {
        return ticketType.equals(TicketType.MANUAL);
    }
}
