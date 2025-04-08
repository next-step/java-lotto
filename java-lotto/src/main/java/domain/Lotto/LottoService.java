package domain.Lotto;

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

    public LottoResult calculateResults(List<LottoTicket> tickets, LottoTicket winningTicket, int bonusNumber) {
        Map<Rank, Integer> matchCounts = new HashMap<>();
        for (LottoTicket ticket : tickets) {
            int matchCount = ticket.countMatchingNumbersWith(winningTicket);
            boolean matchBonus = ticket.contains(bonusNumber);

            Rank rank = Rank.valueOf(matchCount, matchBonus);
            matchCounts.put(rank, matchCounts.getOrDefault(rank, 0) + 1);
        }
        return new LottoResult(matchCounts);
    }

}
