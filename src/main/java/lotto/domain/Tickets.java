package lotto.domain;

import java.util.Objects;

public class Tickets {

    private final int manualCount;
    private final int autoCount;

    public Tickets(int manualCount, PaidAmount paidAmount) {
        this.manualCount = manualCount;
        this.autoCount = calculateAutoCount(paidAmount);
    }

    private int calculateAutoCount(PaidAmount paidAmount) {
        int availableTicketNo = paidAmount.getPurchasableTicketNo();

        if (availableTicketNo < manualCount) {
            throw new IllegalArgumentException("구매할 수 있는 개수가 아닙니다.");
        }

        return availableTicketNo - manualCount;
    }

    public int getManualCount() {
        return this.manualCount;
    }

    public int getAutoCount() {
        return this.autoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets1 = (Tickets) o;
        return manualCount == tickets1.manualCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualCount);
    }
}
