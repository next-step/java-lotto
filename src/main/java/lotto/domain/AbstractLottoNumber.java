package lotto.domain;

import java.util.Set;

public abstract class AbstractLottoNumber {

    protected final Ticket ticket;

    public AbstractLottoNumber(Ticket ticket) {
        this.ticket = ticket;
    }

    public Set<Integer> getNumbers() {
        return ticket.getNumbers();
    }

    @Override
    public abstract String toString();
}
