package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    private List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.tickets = lottoTickets;
    }

    public int size() {
        return tickets.size();
    }

    public Map<Integer,Integer> checkWin(LottoTicket ticket) {
        HashMap<Integer, Integer> result = new HashMap<>();

        for (LottoTicket lottoTicket : tickets) {
            int matchCount = lottoTicket.correctWith(ticket);

            if (result.containsKey(matchCount)) {
                result.put(matchCount, result.get(matchCount) + 1);
            } else {
                result.put(matchCount, 1);
            }
        }

        return result;
    }
}