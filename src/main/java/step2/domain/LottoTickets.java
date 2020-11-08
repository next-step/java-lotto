package step2.domain;

import step2.strategy.NumberMakeStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    public LottoTickets(int count, NumberMakeStrategy strategy) {
        tickets = new ArrayList<>();
        IntStream.range(0, count)
                .forEach(index-> tickets.add(new LottoTicket(strategy)));
    }

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }
}
