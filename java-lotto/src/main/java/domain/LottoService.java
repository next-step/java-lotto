package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MAX_NUMBER = 45;

    public List<LottoTicket> generateLottoTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }

    public LottoResult calculateResults(List<LottoTicket> tickets, List<Integer> winningNumbers) {
        Map<Integer, Integer> matchCounts = new HashMap<>();
        for (LottoTicket ticket : tickets) {
            int matchCount = ticket.getMatchCount(winningNumbers);
            matchCounts.put(matchCount, matchCounts.getOrDefault(matchCount, 0) + 1);
        }
        return new LottoResult(matchCounts);
    }

}
