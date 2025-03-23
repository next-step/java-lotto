package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {
    public static List<LottoResult> checkTickets(List<LottoTicket> tickets, LottoTicket winningTicket) {
        List<LottoResult> results = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            int matchCount = ticket.getMatchCount(winningTicket);
            results.add(new LottoResult(ticket, new MatchCount(matchCount)));
        }
        return results;
    }
}
