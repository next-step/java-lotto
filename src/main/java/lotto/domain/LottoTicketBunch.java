package lotto.domain;

import lotto.dto.TicketData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicketBunch {
    private List<LottoTicket> tickets;

    public LottoTicketBunch() {
        this.tickets = new ArrayList<>();
    }

    public LottoTicketBunch(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public Integer getSize() {
        return tickets.size();
    }

    public LottoTicketBunch merge (LottoTicketBunch otherBunch) {
        return new LottoTicketBunch(
            Stream.concat(
                tickets.stream(),
                otherBunch.tickets.stream()
            ).collect(
                Collectors.toList()
            )
        );
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

    public List<TicketData> getTicketsData() {
        return tickets.stream().map(
            ticket -> ticket.getTicketData()
        ).collect(
            Collectors.toList()
        );
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
