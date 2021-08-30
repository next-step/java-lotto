package lotto.game;

import lotto.number.RandomNumbers;
import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private final Payments payments;
    private final LottoTickets tickets;

    public LottoGame(int totalPayments) {
        this.payments = new Payments(totalPayments);
        this.tickets = new LottoTickets(initTickets());
    }

    private List<LottoTicket> initTickets() {
        return IntStream.range(0, payments.ticketCount())
                .mapToObj(i -> new LottoTicket(new RandomNumbers().value()))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return this.tickets.value();
    }

    public Payments payments() {
        return this.payments;
    }
}
