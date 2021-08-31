package lotto.ticket;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(int[][] numbers) {
        this(Arrays.stream(numbers)
                .map(LottoTicket::new)
                .collect(Collectors.toList()));
    }

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<LottoTicket> value() {
        return tickets;
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
}
