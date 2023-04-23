package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public Map<Integer, Integer> calculateLottoStatistics(Set<Integer> winningNumbers) {
        Map<Integer, Integer> lottoStatistics = new HashMap<>();
        lottoStatistics.put(3, 0);
        lottoStatistics.put(4, 0);
        lottoStatistics.put(5, 0);
        lottoStatistics.put(6, 0);

        for (LottoTicket ticket : tickets) {
            int matchCount = ticket.matchCount(winningNumbers);
            if (matchCount >= 3) {
                lottoStatistics.put(matchCount, lottoStatistics.get(matchCount) + 1);
            }
        }

        return lottoStatistics;
    }

    public int size() {
        return tickets.size();
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }
}
