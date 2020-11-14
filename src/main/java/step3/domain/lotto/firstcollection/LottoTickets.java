package step3.domain.lotto.firstcollection;

import step3.domain.lotto.LottoTicket;
import step3.strategy.NumberMakeStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    public static final int START_INDEX = 0;
    private final List<LottoTicket> tickets;

    public LottoTickets(int count, NumberMakeStrategy strategy) {
        tickets = IntStream.range(START_INDEX, count)
                .mapToObj(index -> new LottoTicket(strategy))
                .collect(Collectors.toList());
    }

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public int countTicket() {
        return tickets.size();
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        tickets.forEach(ticket -> sb.append(ticket.toString())
                .append(System.lineSeparator()));
        return sb.toString();
    }
}
