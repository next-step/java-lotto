package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicketBunch {
    private List<LottoTicket> tickets;

    public LottoTicketBunch(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public LottoScoreBoard calcScoreBoard(LottoAnswer answer) {
        return new LottoScoreBoard(
            tickets.stream().map(
                ticket -> answer.calculateScore(ticket)
            ).collect(
                Collectors.toList()
            )
        );
    }

    public int getSize() {
        return tickets.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicketBunch that = (LottoTicketBunch) o;
        return Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }
}
