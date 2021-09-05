package lotto.game;

import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;

import java.util.List;

public class LottoGame {
    private final Payments payments;
    private final LottoTickets tickets;

    public LottoGame(int totalPayments) {
        this.payments = new Payments(totalPayments);
        this.tickets = new LottoTickets(payments.ticketCount());
    }

    public LottoGame(int totalPayments, List<LottoTicket> manualLottoTickets) {
        this.payments = new Payments(totalPayments);
        this.tickets = new LottoTickets(payments.ticketCount(), manualLottoTickets);
    }

    public List<LottoTicket> lottoTickets() {
        return this.tickets.value();
    }

    public Payments payments() {
        return this.payments;
    }

    public int manualTicketCount() {
        return tickets.manualTicketCount();
    }

    public int autoTicketCount() {
        return tickets.autoTicketCount();
    }
}
