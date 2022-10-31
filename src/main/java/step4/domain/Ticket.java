package step4.domain;

public class Ticket {

    private final int countOfTicket;

    private Ticket(final int countOfTicket) {
        validateTicket(countOfTicket);
        this.countOfTicket = countOfTicket;
    }

    public static final Ticket from(final int ticketCount) {
        return new Ticket(ticketCount);
    }

    private void validateTicket(final int countOfTicket) {
        if (countOfTicket < 0) {
            throw new IllegalArgumentException("티켓 갯수는 음수일 수 없습니다.");
        }
    }

    public final int getCountOfTicket() {
        return countOfTicket;
    }
}
