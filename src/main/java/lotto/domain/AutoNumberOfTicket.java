package lotto.domain;

import java.util.Objects;

public class AutoNumberOfTicket {
    private final ManualNumberOfTicket manualNumberOfTicket;
    private final TotalNumberOfTicket totalNumberOfTicket;
    private final int autoNumberOfTicket;

    public AutoNumberOfTicket(ManualNumberOfTicket manualNumberOfTicket, TotalNumberOfTicket totalNumberOfTicket) {
        this.manualNumberOfTicket = manualNumberOfTicket;
        this.totalNumberOfTicket = totalNumberOfTicket;
        this.autoNumberOfTicket = totalNumberOfTicket.minus(manualNumberOfTicket);
    }

    public int numberOfTicket() {
        return autoNumberOfTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoNumberOfTicket that = (AutoNumberOfTicket) o;
        return autoNumberOfTicket == that.autoNumberOfTicket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoNumberOfTicket);
    }
}
