package lotto.domain;

import lotto.generic.Money;

import java.util.Objects;

public class TicketCount {
    public static final Money LOTTO_PRICE = Money.wons(1000L);

    private final int ticketCount;

    public TicketCount(final int ticketCount) {
        validateIsNotNegativeNumber(ticketCount);
        this.ticketCount = ticketCount;
    }

    private void validateIsNotNegativeNumber(final int ticketCount) {
        if (ticketCount < 0) {
            throw new IllegalArgumentException("티켓 수량은 최소 0이상입니다.");
        }
    }

    public static TicketCount calculateTicketCount(Money amount) {
        return new TicketCount(amount.divideAndDiscardRemainder(LOTTO_PRICE));
    }

    public TicketCount minus(TicketCount ticketCount) {
        return new TicketCount(this.ticketCount - ticketCount.getValue());
    }

    public int getValue() {
        return ticketCount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TicketCount that = (TicketCount) o;
        return ticketCount == that.ticketCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketCount);
    }
}
