package lotto.domain;

import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;
    private TicketGenerator ticketGenerator;

    public LottoTickets(TicketGenerator ticketGenerator, int count) {
        this.ticketGenerator = ticketGenerator;
        this.lottoTickets = createTicketsBy(count);
    }

    public LottoTickets(List<LottoTicket> tickets) {
        this.lottoTickets = tickets;
    }

    private List<LottoTicket> createTicketsBy(int count) {
        return ticketGenerator.generate(count);
    }

    public LottoResult matchingResultWith(WinningNumbers winningNumbers) {
        return new LottoResult(winningNumbers, lottoTickets);
    }

    public int count() {
        return lottoTickets.size();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoTicket ticket : lottoTickets) {
            stringBuilder.append(ticket.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public void combineWith(LottoTickets others) {
        lottoTickets.addAll(others.lottoTickets);
    }
}
