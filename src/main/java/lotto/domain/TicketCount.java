package lotto.domain;

import lotto.exception.WrongTicketCountException;

public class TicketCount {

    private final int ticketCount;

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
}
