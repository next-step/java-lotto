package lotto.domain.model.lotto;

import java.util.Objects;

public class TicketCount {
    private final int count;

    public TicketCount(final int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("티켓 수량은 0보다 커야 합니다.");
        }
        this.count = count;
    }

    public static TicketCount from(final PurchaseAmount purchaseAmount, final TicketPrice ticketPrice) {
        return new TicketCount(purchaseAmount.getAmount() / ticketPrice.getPrice());
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketCount that = (TicketCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
} 
