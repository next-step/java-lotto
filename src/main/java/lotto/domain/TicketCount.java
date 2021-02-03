package lotto.domain;

import java.util.Objects;
import java.util.stream.IntStream;
import lotto.util.NumberUtils;

public class TicketCount {

    private final Integer ticketCount;

    public TicketCount(Integer ticketCount) {
        this.ticketCount = ticketCount;
    }

    public TicketCount(String ticketCount, TicketCount totalTicketCount) throws IllegalArgumentException {
        validateTicketCount(ticketCount, totalTicketCount.ticketCount);
        this.ticketCount = NumberUtils.returnInteger(ticketCount);
    }

    public Integer getTicketCount() {
        return ticketCount;
    }

    private void validateTicketCount(String ticketCount, Integer totalTicketCount)
        throws IllegalArgumentException {
        if (NumberUtils.returnInteger(ticketCount) > totalTicketCount) {
            throw new IllegalArgumentException();
        }
    }

    public IntStream createTicketCountStream() {
        return IntStream.range(0, ticketCount);
    }

    public TicketCount minus(TicketCount ticketCount) {
        return new TicketCount(this.ticketCount - ticketCount.ticketCount);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TicketCount that = (TicketCount) o;
        return Objects.equals(ticketCount, that.ticketCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketCount);
    }
}
