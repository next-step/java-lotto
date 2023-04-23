package lotto;

import java.util.List;
import java.util.Set;

public class LottoTickets {
    private final List<LottoTicket> tickets;
    private final LottoStatistics lottoStatistics = new LottoStatistics();

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public void calculateLottoStatistics(Set<Integer> winningNumbers) {
        for (LottoTicket ticket : tickets) {
            lottoStatistics.increment(ticket.matchCount(winningNumbers));
        }
    }

    public LottoStatistics getLottoStatistics() {
        return lottoStatistics;
    }

    public int size() {
        return tickets.size();
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }
}
