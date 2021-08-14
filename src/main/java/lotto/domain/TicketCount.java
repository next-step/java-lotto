package lotto.domain;

import java.util.Objects;
import lotto.exception.WrongTicketCountException;

public class TicketCount {

    private static final int DEFAULT_COUNT = 0;
    private final int ticketCount;

    public TicketCount() {
        this(DEFAULT_COUNT);
    }

    public TicketCount(int ticketCount) {
        validate(ticketCount);
        this.ticketCount = ticketCount;
    }

    private void validate(int ticketCount) {
        if (ticketCount < 0) {
            throw new WrongTicketCountException(
                String.format("잘못된 티켓장수가 입력되었습니다. [입력장수:%d]", ticketCount));
        }
    }

    public int value() {
        return ticketCount;
    }

    public TicketCount minus(TicketCount anotherCount) {
        return new TicketCount(ticketCount - anotherCount.value());
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
        return ticketCount == that.ticketCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketCount);
    }
}
