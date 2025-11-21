package lotto.domain;

import java.util.Objects;

public class TicketCount {

    private final int value;

    public TicketCount(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketCount that = (TicketCount) o;
        return getValue() == that.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValue());
    }
}
