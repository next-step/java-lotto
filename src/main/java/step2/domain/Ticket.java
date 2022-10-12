package step2.domain;

public class Ticket {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private final int ticketCount;

    private Ticket(final int price) {
        validatePrice(price);
        this.ticketCount = toLottoTicket(price);
    }

    public static final Ticket from(final int price) {
        return new Ticket(price);
    }

    private void validatePrice(final int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("구입금액은 양수여야 합니다.");
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException("로또티켓은 한 장 당 1000원입니다.");
        }
    }

    public int toLottoTicket(final int price) {
        return price / LOTTO_TICKET_PRICE;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
