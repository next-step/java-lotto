package lotto.domain;

import java.util.Objects;

public class TicketCount {

    private final int autoTicketCount;
    private final int passiveTicketCount;

    public TicketCount(int price, int passiveTicketCount) {
        this.autoTicketCount = (price / 1_000) - passiveTicketCount;
        this.passiveTicketCount = passiveTicketCount;
    }

    public void create(Runnable runnable) {
        for (int i = 0; i < this.autoTicketCount; i++) {
            runnable.run();
        }
    }

    public int getAutoTicketCount() {
        return this.autoTicketCount;
    }

    public int getPassiveTicketCount() {
        return passiveTicketCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketCount that = (TicketCount) o;
        return getAutoTicketCount() == that.getAutoTicketCount();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getAutoTicketCount());
    }
}
