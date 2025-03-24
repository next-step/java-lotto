package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    public static Map<PrizeRank, Integer> getSummary(List<LottoTicket> tickets, LottoTicket winningTicket) {
        List<LottoResult> results = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            results.add(ticket.matchWinner(winningTicket));
        }

        Map<PrizeRank, Integer> summary = new HashMap<>();
        for (LottoResult result : results) {
            summary.put(result.getRank(), summary.getOrDefault(result.getRank(), 0) + 1);
        }

        return summary;
    }
}
