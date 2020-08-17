package lotto.domain;

import java.util.Set;

public class AbstractLottoNumber {

    protected final Ticket ticket;

    public AbstractLottoNumber(Ticket ticket) {
        this.ticket = ticket;
    }

    public Set<Integer> getNumbers() {
        return ticket.getNumbers();
    }

    public int getBonus() {
        return ticket.getBonus();
    }

    @Override
    public String toString() {
        return ticket.toString();
    }
}
