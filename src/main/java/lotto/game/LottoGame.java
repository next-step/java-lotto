package lotto.game;

import lotto.number.LottoNumberLimit;
import lotto.number.LottoNumbers;
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
        int ticketCount = ticketCount(payments.getValue());
        this.tickets = new LottoTickets(initTickets(ticketCount));
    }

    private List<LottoTicket> initTickets(int ticketCount) {
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> new LottoTicket(new RandomNumbers(LottoNumberLimit.MIN.value(), LottoNumberLimit.MAX.value(), LottoNumbers.NUMBERS_LENGTH).value()))
                .collect(Collectors.toList());
    }

    private int ticketCount(int payments) {
        return payments / LottoTicket.PRICE;
    }

    public List<LottoTicket> getLottoTickets() {
        return this.tickets.getValue();
    }

    public Payments payments() {
        return this.payments;
    }
}
