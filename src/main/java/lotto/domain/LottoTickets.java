package lotto.domain;

import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;
    private final TicketGenerator ticketGenerator;
    private final int count;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
        this.ticketGenerator = new AutoLottoTicketGenerator();
        this.count = 0;
    }

    public LottoTickets(TicketGenerator ticketGenerator, int count) {
        this.ticketGenerator = ticketGenerator;
        this.count = count;
        this.lottoTickets = createTicketsBy(count);
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

    public void combineWith(List<LottoTicket> others) {
        lottoTickets.addAll(others);
    }
}
