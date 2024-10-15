package lotto.domain.lotto.ticket;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public LottoTickets(LottoTicket... ticket) {
        this.tickets = Arrays.stream(ticket).collect(Collectors.toList());
    }

    public void add(LottoTicket ticket) {
        tickets.add(ticket);
    }

    public List<Integer> getHitNumbers(LottoTicket winninglottoTicket) {
        return tickets.stream().map(lottoTicket -> lottoTicket.hitNumber(winninglottoTicket.getNumbers()))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getTickets() {
        return this.tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "tickets=" + tickets +
                '}';
    }
}
