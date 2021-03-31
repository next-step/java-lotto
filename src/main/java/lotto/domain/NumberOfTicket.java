package lotto.domain;

import java.util.Objects;

public class NumberOfTicket {

    private final int numberOfTicket;

    public NumberOfTicket(int numberOfTicket) {
        this.numberOfTicket = numberOfTicket;
    }

    public int count() {
        return numberOfTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberOfTicket that = (NumberOfTicket) o;
        return numberOfTicket == that.numberOfTicket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfTicket);
    }
}
