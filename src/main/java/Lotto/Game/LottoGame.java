package Lotto.Game;

import Lotto.Number.RandomNumbers;
import Lotto.Ticket.LottoTicket;
import Lotto.Ticket.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private final LottoTickets tickets;
    private final Payments payments;

    public LottoGame(int totalPayments) {
        this.payments = new Payments(totalPayments);
        int totalNumberOfTickets = calculateTotalNumberOfTickets(payments.getValue());
        List<LottoTicket> tickets = createLottoTickets(totalNumberOfTickets);
        this.tickets = new LottoTickets(tickets);
    }

    private List<LottoTicket> createLottoTickets(int totalNumberOfTickets) {
        return IntStream.range(0, totalNumberOfTickets).mapToObj(i -> new LottoTicket(RandomNumbers.generate())).collect(Collectors.toList());
    }

    private int calculateTotalNumberOfTickets(int payments) {
        return payments / LottoTicket.PRICE;
    }

    public List<LottoTicket> getLottoTickets() {
        return this.tickets.getValue();
    }
}
