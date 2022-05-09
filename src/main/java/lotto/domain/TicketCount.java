package lotto.domain;

public class TicketCount {
    final static int ZERO = 0;

    private final int ticketCount;

    public TicketCount(String ticketCount) {
        this(Integer.parseInt(ticketCount));
    }

    public TicketCount(int ticketCount) {
        validate(ticketCount);
        this.ticketCount = ticketCount;
    }

    private void validate(int ticketCount) {
        if (ticketCount < ZERO) {
            throw new IllegalArgumentException(String.format("TicketCount(%s)는 %s 미만일 수 없습니다.", ticketCount, ZERO));
        }
    }

    public boolean isZero() {
        return ticketCount == ZERO;
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
