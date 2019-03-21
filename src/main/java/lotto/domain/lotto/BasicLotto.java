package lotto.domain.lotto;

import java.util.List;

public class BasicLotto implements Lotto {
    private Ticket ticket;

    public BasicLotto(Ticket ticket) {
        this.ticket = ticket;
    }

    public BasicLotto(List<LottoNumber> numbers) {
        this.ticket = new Ticket(numbers);
    }

    public Ticket getTicket() {
        return ticket;
    }

    @Override
    public String toString() {
        return ticket.toString();
    }
}
